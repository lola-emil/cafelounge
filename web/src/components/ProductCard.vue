<script setup lang="ts">
const props = defineProps(["product", "description", "price", "img"]);
const emit = defineEmits(["on-add"])

function onAdd() {
    emit("on-add");    
}
</script>

<template>
    <div class="card bg-base-300 h-max overflow-hidden shadow relative">
        <div class="card-body p-4">
            <div class="w-full bg-white">
                <img :src="props.img" class="w-full object-contain rounded">
            </div>

            <p class="font-semibold">{{ props.product }}</p>
            <!-- <p class="line-clamp-2 text-xs">{{ props.description ?? "--" }}</p> -->

            <div class="flex">
                <p class="font-semibold text-lg">${{ props.price.toFixed(2) }}</p>
                <button class="btn btn-sm" @click="onAdd()">Add</button>
            </div>
        </div>
    </div>
</template>