<script setup lang="ts">
import { reactive } from "vue";
import * as authService from "../services/auth-service";


let userData = reactive({
    username: "",
    password: ""
});

function login() {
    authService.signIn(userData)
    .then(data => {
        console.log(data);
    }).catch(error => {
        console.log(error);
    });
}

</script>

<template>

    <div class="h-screen w-full flex justify-center items-center">
        <form @submit.prevent="login()" class="card w-xs">
            <div class="card-body gap-5">
                <input v-model="userData.username" type="text" class="input w-full" placeholder="Username">
                <input v-model="userData.password" type="password" class="input w-full" placeholder="Password">
                <button class="btn btn-primary w-full">Log In</button>
            </div>
        </form>
    </div>

</template>