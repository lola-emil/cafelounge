<script setup lang="ts">
import ProductCard from "@/components/ProductCard.vue";
import { reactive, ref, onMounted, computed } from "vue";

import * as productService from "../services/product-service";

let itemCategories = ["Burgers", "Pizza", "Ice Cream", "Drink"];

let products = ref<productService.Product[]>([]);

let cartItems = reactive<productService.Product[]>([]);

let summary = computed(() => {
  const subtotal = cartItems.reduce((sum, item) => sum + item.price, 0);
  let discount = 0;
  let tax = 0;
  
  return {
    subtotal: subtotal.toFixed(2),
    discount: discount.toFixed(2),
    tax: tax.toFixed(2),
    total: (subtotal - discount + tax).toFixed(2)
  }
})

function addToCart(product: productService.Product) {
  cartItems.push(product);
}

onMounted(async () => {
  const data = await productService.getProducts();
  console.log(data);

  products.value = data;
});
</script>

<template>
  <main class="px-10 mt-5">
    <div class="flex justify-between items-center">
      <h3 class="text-2xl font-semibold">Point of sales</h3>

      <button class="btn btn-primary">Add Product</button>
    </div>

    <div class="mt-5 flex gap-5 flex-1">
      <div class="card bg-base-200 h-[calc(90vh-4.75rem)]  overflow-auto flex-1">
        <div class="card-body flex pt-0 flex-col relative">
          <div class="sticky top-0 z-10 pt-6 bg-base-200">
            <div class="flex justify-between items-center">
              <p class="font-semibold">Product category</p>

              <div class="join grid grid-cols-2">
                <button class="join-item btn btn-sm btn-outline">«</button>
                <button class="join-item btn btn-sm btn-outline">»</button>
              </div>
            </div>

            <!-- Categories -->
            <div class="flex gap-3 mt-3">
              <div class="card bg-base-300 w-40" v-for="category in itemCategories">
                <div class="card-body p-2">
                  <span class="font-semibold">{{ category }}</span>
                  <small>{{ 9 }} items</small>
                </div>
              </div>
            </div>

            <div class="flex justify-between w-full my-3">
              <div></div>
              <div>
                <p>
                  <span class="font-semibold">Showing </span>
                  <span>{{ 36 }} Results</span>
                </p>
              </div>
            </div>
          </div>

          <!-- Product List -->
          <!-- I want this section to be scrollable as well -->
          <div class="grid grid-cols-3 gap-5 flex-1 pr-1">
            <ProductCard
              v-for="item in products"
              @click="addToCart(item)"
              img="https://cdn.prod.website-files.com/631b4b4e277091ef01450237/686e703d7cc50185a9667d87_BBQ_Brisket_1_Jr%20(1).jpg"
              :description="item.description"
              :product="item.name"
              :price="item.price"
            />
          </div>
        </div>
      </div>

      <div class="min-w-sm card bg-base-200 h-[calc(90vh-4.75rem)] sticky top-5 flex flex-col">
        <div class="card-body w-full relative flex flex-col flex-grow overflow-hidden">

          <div>
            <p class="font-semibold">Current Orders</p>
          </div>

          <div v-if="cartItems.length == 0" class="flex justify-center flex-1 items-center">
            No item selected
          </div>
          <!-- Scrollable List -->
          <ul class="flex flex-col gap-3 mt-6 overflow-auto pr-1 flex-1">
            <li v-for="item in cartItems" :key="item.id">
              <div class="card bg-base-300">
                <div class="card-body p-3">
                  <div class="flex justify-between">
                    <div>
                      <p>{{ item.name }}</p>
                      <p class="font-semibold">{{ item.price }}</p>
                    </div>
                  </div>
                </div>
              </div>
            </li>
          </ul>

          <!-- Fixed-bottom summary INSIDE the card -->
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
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>
