import { Identifier, RaRecord } from "react-admin";


export interface UserInfo extends RaRecord{
    id: Identifier;
    name: string;
    email: string;
    address: string;
    phoneNumber: string;
    createdAt?: string;
    updatedAt?: string;
}