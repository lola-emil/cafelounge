import { getProfile } from "@/services/auth-service";
import { defineStore } from "pinia";

interface Profile {
  username: string;
}

export const useAuthStore = defineStore("auth", {
  state: (): {
    user: Profile | null
  } => ({
    user: null,
  }),

  getters: {
    isAuthenticated: (state) => !!state.user
  },

  actions: {
    async fetchUser() {
      const res = await getProfile();
       this.user = res.data;
    }
  }
});
