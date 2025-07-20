<script setup lang="ts">
import Trend from './icons/Trend.vue';
import AppsIcon from './icons/AppsIcon.vue';
</script>

<template>
    <div class="navbar bg-base-100 shadow-sm">
        <div class="flex-none">
            <div class="dropdown dropdown-start">
                <button tabindex="0" class="btn btn-square btn-ghost">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                        class="inline-block h-5 w-5 stroke-current">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M4 6h16M4 12h16M4 18h16">
                        </path>
                    </svg>
                </button>

                <ul tabindex="0" class="dropdown-content menu bg-base-200 rounded-box z-1 w-52 p-2 shadow-sm">
                    <li><a>
                            <AppsIcon />
                            Point of Sales
                        </a></li>
                    <li><a>
                            <Trend />
                            Reports
                        </a></li>
                </ul>
            </div>
        </div>
        <div class="flex-1">
        </div>
        <div class="flex-none">
            <button class="btn btn-square btn-ghost">
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                    class="inline-block h-5 w-5 stroke-current">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                        d="M5 12h.01M12 12h.01M19 12h.01M6 12a1 1 0 11-2 0 1 1 0 012 0zm7 0a1 1 0 11-2 0 1 1 0 012 0zm7 0a1 1 0 11-2 0 1 1 0 012 0z">
                    </path>
                </svg>
            </button>
        </div>
    </div>
</template>
