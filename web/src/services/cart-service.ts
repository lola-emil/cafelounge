import { axiosInstance } from "@/utils/axiosInstance";
interface Cart {
    id: number;

};


export async function getCart(id: number) {
    const res = await axiosInstance.get("/carts/" + id);
    return res.data;
}

export async function addCart() {
    const res = await axiosInstance.post("/carts", {});
    return res.data;
}

