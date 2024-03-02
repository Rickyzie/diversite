import axios from "axios";
import { ApiReturnType } from "./types/serviceTypes";

const adminRequest = axios.create({
    baseURL: '/api/admins'
});

export async function AdminLogin(adminName: string, password: string) {
    try {
        const { data } = await adminRequest.post<ApiReturnType<string>>(
            "/login", 
            {
                adminName: adminName,
                password: password,
            },
            {
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
            }
        );
        if(data.status === "error"){
            throw data;
        }else if (data.status === "success"){
            return data;
        }
    }catch(error){
        throw error;
    }
}