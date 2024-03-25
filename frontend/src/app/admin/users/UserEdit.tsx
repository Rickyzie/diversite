import { Edit, NumberInput, SimpleForm, TextInput } from "react-admin";

export default function UserEdit(){

    return (
        <Edit title = "編輯使用者">
            <SimpleForm>
                <NumberInput disabled source="id"/>
                <TextInput  source="name"/>
                <TextInput  source="email"/>
                <TextInput  source="phoneNumber"/>
                <TextInput  source="address"/>
            </SimpleForm>
        </Edit>
    )
}