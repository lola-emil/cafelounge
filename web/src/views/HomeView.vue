<script setup lang="ts">
import ProductCard from "@/components/ProductCard.vue";
import AddProductModal from "@/components/AddProductModal.vue";
import Navbar from "@/components/Navbar.vue";
import OrderSummary from "@/components/OrderSummary.vue";


import { useTitle } from "@vueuse/core";

import { ref, onMounted, onUnmounted, onBeforeMount } from "vue";

import * as productService from "../services/product-service";
import axios from "axios";

let title = useTitle();

let products = ref<productService.Product[]>([]);
let productsLoaded = ref<boolean>(false);
let errorMessage = ref<string | null>(null);

let productAbortController: AbortController | null = null;

let orderSummaryRef = ref<InstanceType<typeof OrderSummary> | null>(null);

function addToCart(product: productService.Product) {
  console.log("product", product);
  orderSummaryRef.value?.addItem(product);
}

function fetchProducts() {
  productAbortController?.abort();

  productAbortController = new AbortController();

  productsLoaded.value = false;
  productService.getProducts(productAbortController.signal)
    .then(data => {
      productsLoaded.value = true;
      products.value = data;
    }).catch(error => {

      if (axios.isCancel(error)) {
        console.log("Request cancelled");
        return;
      }

      errorMessage.value = "Error fetching products";
      productsLoaded.value = true;

      console.error(error);
    });
}





let modalRef = ref<InstanceType<typeof AddProductModal> | null>(null);

function openModal() {
  modalRef.value?.open();
}

function appendProduct(product: productService.Product) {
  products.value.push(product);
}


onBeforeMount(() => {
  title.value = "Point of Sale";
})

onMounted(async () => {
  fetchProducts();
});

onUnmounted(() => {
  productAbortController?.abort();
});
</script>

<template>
  <header>
    <Navbar />
  </header>

  <main class="px-10 mt-5">
    <div class="flex justify-between items-center">
      <h3 class="text-2xl font-semibold">Point of sales</h3>

      <button class="btn btn-primary" @click="openModal()">Add Product</button>
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
              <div class="card bg-base-300 w-40">
                <div class="card-body p-2">
                  <span class="font-semibold">All</span>
                  <small>{{ 0 }} items</small>
                </div>
              </div>

              <!-- <div class="card bg-base-300 w-40" v-for="category in itemCategories">
                <div class="card-body p-2">
                  <span class="font-semibold">{{ category }}</span>
                  <small>{{ 9 }} items</small>
                </div>
              </div> -->
            </div>

            <div class="flex justify-between w-full my-3">
              <div></div>
              <div>
                <p>
                  <span class="font-semibold">Showing </span>
                  <span>{{ products.length }} Results</span>
                </p>
              </div>
            </div>
          </div>

          <!-- Product List -->
          <!-- I want this section to be scrollable as well -->
          <div class="grid grid-cols-3 gap-5 flex-1 pr-1">
            <div class="card bg-base-300 skeleton" v-if="!productsLoaded" v-for="n in 6" :key="n">
            </div>

            <ProductCard v-for="item in products" @on-add="addToCart(item)"
              img="https://cdn.prod.website-files.com/631b4b4e277091ef01450237/686e703d7cc50185a9667d87_BBQ_Brisket_1_Jr%20(1).jpg"
              :description="item.description" :product="item.name" :price="item.price" />

            <div class="text-center col-span-3 gap-3 flex flex-col items-center justify-center"
              v-if="productsLoaded && products.length == 0">
              <div>
                <p class="text-xl font-semibold">{{ errorMessage ?? "No items to display." }}</p>
              </div>
              <button class="btn btn-secondary btn-sm" v-if="errorMessage" @click="fetchProducts()">Reload</button>
            </div>
          </div>
        </div>
      </div>

      <div class="min-w-sm card bg-base-200 h-[calc(90vh-4.75rem)] sticky top-5 flex flex-col">
        <OrderSummary ref="orderSummaryRef"/>
      </div>
    </div>
  </main>

  <AddProductModal ref="modalRef" @product-added="appendProduct" />
</template>
