<script setup lang="ts">
interface Item {
    name: string;
    value: string;
};

interface Props {
    items: Item[],
    label?: string,
    modelValue: string
};

const props = defineProps<Props>();
const emit = defineEmits<{
  (e: "update:modelValue", value?: string): void;
}>();

// Use a local ref to track input value
import { ref, watch } from "vue";
const searchValue = ref(props.modelValue);

// Sync prop changes to internal state
watch(() => props.modelValue, (newVal) => {
  searchValue.value = newVal;
});

function onSelect(index: number) {
    // Emit update for v-model binding
    emit("update:modelValue", props.items[index].name);
}

function onSearch() {
    // Emit the input event (update:modelValue) on user typing
    emit("update:modelValue", searchValue.value);
}
</script>

<template>
    <div class="dropdown">
        <div tabindex="0" class="m-1">
            <input 
                type="text" 
                class="input w-full" 
                :placeholder="label" 
                v-model="searchValue"
                @input="onSearch"
            >
        </div>
        <ul tabindex="0" class="dropdown-content w-full menu bg-base-300 rounded-box z-1 p-2 shadow-sm">
            <li v-for="(item, index) in items" :key="item.value" :data-value="item.value">
                <a role="button" @click="onSelect(index)">
                    {{ item.name }}
                </a>
            </li>
        </ul>
    </div>
</template>
