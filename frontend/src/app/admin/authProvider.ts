import { adminLogin, adminLogout, getAdminInfo } from '@/service/adminService';
import { AuthProvider, UserIdentity } from 'react-admin';

async function login({ username, password }: {username: string, password: string}) {
    try {
        const result = await adminLogin(username, password);
        if(result?.status === "success"){
            return result;
        }
    } catch (error) {
        throw error;
    }
    
}

async function logout() {
    try {
        const result = await adminLogout();
        if(result?.status === "success"){
            return "Login";
        }else {
            return false;
        }
    } catch (error) {
        throw error;
    }
    
}

async function getIdentity(): Promise<UserIdentity> {
    try {
        const result = await getAdminInfo();
        if(result?.status === "success"){
            return {
                id: 'admin',
                fullName: result.data.adminName,
            };
        }else {
            throw new Error("getIdentity error" );
        }
    } catch (error) {
        throw error;
    }
}

const authProvider: AuthProvider = {
    login: login,
    logout: logout,
    checkError: () => Promise.resolve(),
    checkAuth: () => Promise.resolve(),
    getPermissions: () => Promise.resolve(),
    getIdentity:getIdentity,
};

export default authProvider;
