<script setup lang="ts">
import Trend from './icons/Trend.vue';
import AppsIcon from './icons/AppsIcon.vue';

import * as authService from "../services/auth-service";
import router from '@/router';
import { RouterLink } from 'vue-router';

async function logout() {
    const res = await authService.logout();

    if (res.status == 200) {
        router.push("/signin");
    }
}
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
                    <li>
                        <RouterLink to="/">
                            <AppsIcon />
                            Point of Sales
                        </RouterLink>
                    </li>
                    <li>
                        <RouterLink to="/reports">
                            <Trend />
                            Reports
                        </RouterLink>
                    </li>
                </ul>
            </div>
        </div>
        <div class="flex-1">
        </div>
        <div class="flex-none">
            <button class="btn btn-ghost" @click="logout()">
                Logout
            </button>
        </div>
    </div>
</template>
