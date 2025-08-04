<script setup lang="ts">
import { computed, reactive, ref } from "vue";
import * as productService from "../services/product-service";
import { axiosInstance } from "@/utils/axiosInstance";

interface CheckoutItems {
    product: Partial<productService.Product>,
    quantity: number;
}


function incQty(index: number) {
    cartItems[index].quantity += 1;
}
function decQty(index: number) {
    cartItems[index].quantity -= 1;
}

let cartItems = reactive<CheckoutItems[]>([]);

let summary = computed(() => {
    const subtotal = cartItems.reduce((sum, item) => (sum +
        (item.product.price ?? 0) * item.quantity),
        0);

    let discount = 0;
    let tax = 0;

    return {
        subtotal: subtotal.toFixed(2),
        discount: discount.toFixed(2),
        tax: tax.toFixed(2),
        total: (subtotal - discount + tax).toFixed(2)
    }
});


function addItem(product: productService.Product) {
    console.log(product);
    const matchedProduct = cartItems.findIndex((val, index) => val.product.id == product.id);

    if (matchedProduct != -1) {
        cartItems[matchedProduct].quantity += 1;
    }
    else {
        cartItems.push({
            product,
            quantity: 1
        });
    }
}

let checkingOut = ref<boolean>(false);


function checkout() {

    checkingOut.value = true;

    axiosInstance.post("/checkout", {
        checkoutItems: cartItems, paymentMethod: {
            id: 1,
            type: "Cash"
        }
    }).then(res => {
        checkingOut.value = false;
        console.log(res.data);
    }).catch(err => {
        checkingOut.value = false;
        console.log(err);
    });

}

defineExpose({ addItem });
</script>

<template>
    <div class="card-body w-full relative flex flex-col flex-grow overflow-hidden">
        <div>
            <p class="font-semibold">Current Orders</p>
        </div>

        <div v-if="cartItems.length == 0" class="flex justify-center flex-1 items-center">
            No item selected
        </div>
        <!-- Scrollable List -->
        <ul class="flex flex-col gap-3 mt-6 overflow-auto pr-1 flex-1">
            <li v-for="(item, index) in cartItems" :key="item.product.id">
                <div class="card bg-base-300">
                    <div class="card-body p-3">
                        <div class="flex justify-between items-center">
                            <div>
                                <p>{{ item.product.name }}</p>
                                <p class="text-sm">${{ item.product.price }} <span>x {{
                                    item.quantity }}</span>
                                </p>
                            </div>
                            <div>
                                <div>
                                    <p class="font-semibold">${{ (item.product.price ?? 0) * item.quantity }}</p>
                                </div>
                                <div class="flex">
                                    <button class="btn btn-xs" @click="decQty(index)" :disabled="checkingOut">-</button>
                                    <input type="text" class="input input-xs w-14 text-center" :disabled="checkingOut"
                                        v-model="item.quantity">
                                    <button class="btn btn-xs" @click="incQty(index)" :disabled="checkingOut">+</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </li>
        </ul>


        <!-- SUMMARY -->
        <div class="mt-4 px-2">
            <div class="card bg-base-300">
                <div class="card-body p-3">
                    <div class="flex justify-between">
                        <span>Subtotal</span>
                        <span>${{ summary.subtotal }}</span>
                    </div>
                    <div class="flex justify-between">
                        <span>Discount Sales</span>
                        <span>${{ summary.discount }}</span>
                    </div>
                    <div class="flex justify-between">
                        <span>Total Sales Tax</span>
                        <span>${{ summary.tax }}</span>
                    </div>
                    <div class="divider"></div>
                    <div class="flex justify-between">
                        <span>Total</span>
                        <span class="font-semibold">${{ summary.total }}</span>
                    </div>

                    <button class="w-full btn btn-sm mt-3 btn-primary" @click="checkout()" :disabled="checkingOut">
                        {{ checkingOut ? "Loading" : "Checkout" }}
                    </button>
                </div>
            </div>
        </div>
    </div>
</template>