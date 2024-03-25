import axios from "axios";
import { ApiReturnType } from "./types/serviceTypes";
import { UserInfo } from "./types/adminServiceTypes";

const adminRequest = axios.create({
    baseURL: '/api/v1/admin'
});

export async function adminLogin(adminName: string, password: string) {
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

export async function adminLogout() {
    try {
        const { data } = await adminRequest.post<ApiReturnType<string>>(
            "/logout"
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


export async function getAdminInfo() {
    try {
        const { data } = await adminRequest.get<ApiReturnType<{adminName: string}>>(
            "/info"
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

export async function getAdminAllUser() {
    try {
        const { data } = await adminRequest.get<ApiReturnType<UserInfo[]>>(
            "/user"
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

export async function getAdminUserById(id: string) {
    try {
        const { data } = await adminRequest.get<ApiReturnType<UserInfo>>(
            `/user/${id}`
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

export async function updateAdminUser({
    id,
    name,
    email,
    address,
    phoneNumber,
}: Partial<UserInfo>) {
    try {
        const { data } = await adminRequest.put<ApiReturnType<UserInfo>>(
            `/user/${id}`,
            {
                id: id,
                name: name,
                email: email,
                address: address,
                phoneNumber: phoneNumber,
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

export default {
    adminLogin, 
    adminLogout,
    getAdminInfo,
    getAdminAllUser,
    getAdminUserById,
    updateAdminUser, 
}