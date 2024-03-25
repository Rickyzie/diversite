import { Edit, SimpleForm, TextInput } from "react-admin";

export default function UserEdit(){

    return (
        <Edit title = "編輯使用者">
            <SimpleForm>
                <TextInput disabled source="id"/>
                <TextInput  source="name"/>
                <TextInput  source="email"/>
                <TextInput  source="phoneNumber"/>
                <TextInput  source="address"/>
            </SimpleForm>
        </Edit>
    )
}