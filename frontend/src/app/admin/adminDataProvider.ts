import AdminService from '@/service/adminService';
import { UserInfo } from '@/service/types/adminServiceTypes';
import { GetListParams } from 'react-admin';

const adminDataProvider: any = {
    // @ts-ignore
    create: () => Promise.resolve({ data: { id: 0 } }),
    // @ts-ignore
    delete: () => Promise.resolve({ data: {} }),
    deleteMany: () => Promise.resolve({}),
    getList: async (resource: string, params: GetListParams) => {
        switch(resource){
            case "user":
                const result = await AdminService.getAdminAllUser(); 
                if(result){
                    return { data: result.data, total:1};
                }else{
                    throw new Error();
                }
            default:
                return {data: [], total:1}
        }
    },
    getMany: () => Promise.resolve({ data: [] }),
    getManyReference: () => Promise.resolve({ data: [], total: 0 }),
    // @ts-ignore
    getOne: async (resource: string, params: GetListParams) => {
        switch(resource){
            case "user":
                const result = await AdminService.getAdminUserById("1"); 
                if(result){
                    return { data: result.data, total:1};
                }else{
                    throw new Error();
                }
            default:
                return {data: [], total:1}
        }
    },
    // @ts-ignore
    update: () => Promise.resolve({ data: {} }),
    updateMany: () => Promise.resolve({}),
};

export default adminDataProvider;