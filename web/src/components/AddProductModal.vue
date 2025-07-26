<script setup lang="ts">
import { ref, reactive } from 'vue';
import * as productService from "../services/product-service";
import SearchDropdown from "./SearchDropdown.vue";

const emit = defineEmits(["product-added"]);

let dialogRef = ref<HTMLDialogElement | null>(null);
let isLoading = ref<boolean>(false);

function open() {
    dialogRef.value?.showModal();
}

function close() {
    dialogRef.value?.close();
}

let productForm = reactive<Partial<productService.Product>>({});

let productError = reactive<Partial<{
    name: string;
    description: string;
    price: string;
    productCode: string;
}>>({});

function submit() {
    isLoading.value = true;

    console.log(productForm);
    productService.addProduct(productForm)
        .then(data => {
            isLoading.value = false;
            emit("product-added", data);

            console.log("Ang data", data);
            close();
        }).catch(error => {

            alert("naay error");
            isLoading.value = false;

            // Clear previous errors
            Object.keys(productError).forEach(key => {
                delete productError[key as keyof typeof productError];
            });

            // Assign new errors while keeping reactivity
            Object.assign(productError, error.response?.data);

            console.log("What is this error", error);
        });
}

function onClose() {
    Object.keys(productError).forEach(key => {
        delete productError[key as keyof typeof productError];
    });

    Object.keys(productForm).forEach(key => {
        delete productForm[key as keyof typeof productForm];
    });
}

defineExpose({ open, close });

</script>

<template>

    <dialog ref="dialogRef" id="my_modal_1" class="modal" @close="onClose()">
        <div class="modal-box">
            <h3 class="text-lg font-bold">Add Product</h3>
            <div class="mt-3 flex flex-col gap-3">
                <fieldset class="fieldset">
                    <!-- <legend class="fieldset-legend">What is your name?</legend> -->
                    <input type="text" v-model="productForm.name" class="input w-full" :class="{
                        'input-error': !!productError.name
                    }" placeholder="Name" />
                    <p class="label text-error">{{ productError.name ?? "" }}</p>
                </fieldset>
                <fieldset class="fieldset">
                    <textarea v-model="productForm.description" class="textarea h-24 w-full" :class="{
                        'textarea-error': !!productError.description
                    }" placeholder="Description"></textarea>
                    <div class="label text-error">{{ productError.description }}</div>
                </fieldset>

                <fieldset class="fieldset">
                    <input type="text" v-model="productForm.productCode" class="input w-full" :class="{
                        'input-error': !!productError.productCode
                    }" placeholder="Product Code (optional)">
                    <p class="label text-error">{{ productError.productCode }}</p>
                </fieldset>

                <fieldset class="fieldset">
                    <input type="number" v-model="productForm.price" class="input w-full" :class="{
                        'input-error': !!productError.price
                    }" placeholder="Price">
                    <p class="label text-error">{{ productError.price }}</p>
                </fieldset>

                <SearchDropdown :items="[]" v-model="productForm.category" />

            </div>
            <div class="modal-action">
                <button class="btn btn-primary" @click="submit()" :disabled="isLoading">
                    <span v-if="isLoading" class="loading loading-dots loading-sm"></span>
                    <span v-else>Add</span>
                </button>
                <form method="dialog">
                    <!-- if there is a button in form, it will close the modal -->
                    <button class="btn">Close</button>
                </form>
            </div>
        </div>
    </dialog>

</template>