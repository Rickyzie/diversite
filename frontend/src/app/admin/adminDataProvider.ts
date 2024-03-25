import AdminService from '@/service/adminService';
import { UserInfo } from '@/service/types/adminServiceTypes';
import { DataProvider, GetListParams, UpdateParams } from 'react-admin';

const adminDataProvider: DataProvider = {
    // @ts-ignore
    create: () => Promise.resolve({ data: { id: 0 } }),
    // @ts-ignore
    delete: () => Promise.resolve({ data: {} }),
    // @ts-ignore
    deleteMany: () => Promise.resolve({}),
    // @ts-ignore
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
    // @ts-ignore
    getMany: () => Promise.resolve({ data: [] }),
    // @ts-ignore
    getManyReference: () => Promise.resolve({ data: [], total: 0 }),
    // @ts-ignore
    getOne: async (resource, params) => {
        switch(resource){
            case "user":
                const result = await AdminService.getAdminUserById(params.id.toString()); 
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
    update: async (resource, params) => {
        switch(resource){
            case "user":
                const formData = params as UpdateParams<UserInfo>;
                console.log(formData);
                const result = await AdminService.updateAdminUser({...formData.data, id: formData.id}); 
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
    updateMany: () => Promise.resolve({}),
};

export default adminDataProvider;