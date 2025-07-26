<script setup lang="ts">
import { ref } from 'vue';

interface Item {
    name: string;
    value: string;
};

interface Props {
    items: Item[]
};

const props = defineProps<Props>();

let searchValue = defineModel<string>("");

function onSelect(index: number) {
    searchValue.value = props.items[index].name;
}

function onSearch() {
    console.log(searchValue.value);
}

</script>``

<template>
    <div class="dropdown">
        <div tabindex="0" class="m-1">
            <input type="text" class="input w-full" placeholder="Search" 
            v-model="searchValue"
            @input="onSearch()"
            >
        </div>
        <ul tabindex="0" class="dropdown-content w-full menu bg-base-300 rounded-box z-1 p-2 shadow-sm">
            <li v-for="(item, index) in props.items" :data-value="item.value"><a role="button" @click="onSelect(index)">
                {{ item.name }}
            </a></li>
        </ul>
    </div>
</template>