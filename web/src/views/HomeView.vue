<script setup lang="ts">
import Card from '@/components/Card.vue';

  let items = [1,2,34,4];
  let itemCategories = [
    "Burgers",
    "Pizza",
    "Ice Cream",
    "Drink"
  ]
</script>

<template>
  <main class="px-10 mt-10 ">
    <div class="flex justify-between items-center">
      <h3 class="text-2xl font-semibold">Point of sales</h3>

      <button class="btn btn-primary">Add Product</button>
    </div>

    <div class="mt-5 flex gap-10 flex-1">
      <div class="card flex-1">
        <div class="card-body">
          <div>
            <div class="flex justify-between items-center">
              <p class="font-semibold">Product category</p>

              <div class="join grid grid-cols-2">
                <button class="join-item btn btn-sm btn-outline">Previous page</button>
                <button class="join-item btn btn-sm btn-outline">Next</button>
              </div>
            </div>

            <!-- Categories -->
            <div class="flex gap-3 mt-3">
              <div class="card border w-40" v-for="category in itemCategories">
                <div class="card-body p-2">
                  <span class="font-semibold">{{ category }}</span>
                  <small>{{ 9 }} items</small>
                </div>
              </div>
            </div>
          </div>

          <div class="flex flex-row justify-between w-full my-3">
            <div></div>
            <p>
              <span class="font-semibold">Showing </span>
              <span>{{ 36 }} Results</span>
            </p>
          </div>

          <!-- Product List -->
          <div class="grid grid-cols-3 gap-10">
            <Card v-for="item in items"/>
          </div>
        </div>
      </div>

      <div class="min-w-sm card border max-h-[calc(100vh-2.5rem)] sticky top-5">

      </div>
    </div>
  </main>
</template>
