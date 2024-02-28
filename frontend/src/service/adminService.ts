import axios from "axios";
import { ApiReturnType } from "./serviceTypes";

const adminRequest = axios.create({
    baseURL: '/api/admin'
});

export async function AdminLogin(username: string, password: string) {
    try {

        const { data } = await adminRequest.post<ApiReturnType<string>>(
            "/login", 
            {
                username: username,
                password: password,
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