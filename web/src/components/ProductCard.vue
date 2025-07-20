<script setup lang="ts">
const props = defineProps(["product", "description", "price", "img"]);
</script>

<template>
    <div class="card bg-base-300 shadow relative">
        <div class="card-body p-4">
            <div class="w-full bg-white">
                <img :src="props.img" class="w-full object-contain rounded">
            </div>

            <p class="font-semibold">{{ props.product }}</p>
            <p>{{ props.description }}</p>
            <p class="font-semibold text-lg">{{ props.price }}</p>
        </div>
    </div>
</template>