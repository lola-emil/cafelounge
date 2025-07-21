import { axiosInstance } from "@/utils/axiosInstance";
import { useAuthStore } from "@/stores/auth";


export interface User {
  username: string;
};

export async function signIn(data: { username?: string; password?: string }) {
  const res = await axiosInstance.post("/auth/signin", data, {
    headers: {
      "Content-Type": "application/json",
    },
  });

  
  return res.data;
}

export async function getProfile() {
  return await axiosInstance.get<{username: string}>("/auth/profile");
}

export async function logout() {
  return await axiosInstance.post<string>("/auth/logout");
}