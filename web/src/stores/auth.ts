import type { User } from "@/services/auth-service";
import { defineStore } from "pinia";

export const useAuthStore = defineStore("auth", {
  state: (): {
    user: User | null
  } => ({
    user: null,
  }),

  getters: {
    isAuthenticated: (state) => !!state.user,
  },

  actions: {
    async storeUser(user: User) {
        this.user = user;
    }
  }
});
