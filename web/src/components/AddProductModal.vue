<script setup lang="ts">
import { ref, reactive } from 'vue';
import * as productService from "../services/product-service";

let dialogRef = ref<HTMLDialogElement | null>(null);

function open() { 
    dialogRef.value?.showModal();
}

function close() { 
    dialogRef.value?.close();
}

let productForm = reactive<Partial<productService.Product>>({
    name: "",
    description: ""
})

function submit() {
    productService.addProduct(productForm)
    .then(data => {
        console.log(data);
    }).catch(error => {
        console.log(error);
    });
}

defineExpose({ open, close });

</script>

<template>

    <dialog ref="dialogRef" id="my_modal_1" class="modal">
        <div class="modal-box">
            <h3 class="text-lg font-bold">Add Product</h3>
            <div class="mt-3 flex flex-col gap-3">
                <input type="text" v-model="productForm.name" class="input w-full" placeholder="Name">
                <textarea v-model="productForm.description" class="textarea w-full" placeholder="Description"></textarea>
                <input type="text" v-model="productForm.price" class="input w-full" placeholder="Price">
            </div>
            <div class="modal-action">
                <button class="btn btn-primary" @click="submit()">Add</button>
                <form method="dialog">
                    <!-- if there is a button in form, it will close the modal -->
                    <button class="btn">Close</button>
                </form>
            </div>
        </div>
    </dialog>

</template>