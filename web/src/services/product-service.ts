import axios from "axios";

const apiURL = "http://localhost:8080/products";

export interface Product {
  id: number;
  name: string;
  description: string;
  price: number;
}

export async function getProducts(signal?: AbortSignal) {
  const res = await axios.get<Product[]>(apiURL, {
    signal,
  });
  return res.data;
}

export async function addProduct(product: Partial<Product>) {
  const res = await axios.post<Product>(apiURL, product, {
    headers: {
      "Content-Type": "application/json",
    },
  });

  return res.data;
}

export async function postProduct(product: Partial<Product>) {
  const res = await axios.patch<Product>(apiURL, product, {
    headers: {
      "Content-Type": "application/json",
    },
  });

  return res.data;
}
