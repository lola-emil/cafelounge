import { axiosInstance } from "@/utils/axiosInstance";
export interface Product {
  id: number;
  name: string;
  description: string;
  price: number;
}

export async function getProducts(signal?: AbortSignal) {
  const res = await axiosInstance.get("/products", {
    signal,
  });
  return res.data.content;
}

export async function addProduct(data: Partial<Product>, signal?: AbortSignal): Promise<Product> {
  const res = await axiosInstance.post("/products", data, { signal });
  return res.data;
}
