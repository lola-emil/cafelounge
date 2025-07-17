import axios from "axios";


export interface Product {
    id: number;
    name: string;
    description: string;
    price: number;
}

export async function getProducts() {
    const res = await axios.get<Product[]>("http://localhost:3000/products");
    return res.data;
}