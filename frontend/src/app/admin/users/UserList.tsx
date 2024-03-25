import { Datagrid, DeleteButton, EditButton, List, NumberField, Show, SimpleShowLayout, TextField } from "react-admin";

export default function UserList(){
    return (
        <List>
            <Datagrid>
                <NumberField source="id" />
                <TextField source="name" />
                <TextField source="email"/>
                <TextField source="phoneNumber"/>
                <TextField source="address"/>
                <TextField source="createdAt"/>
                <TextField source="updatedAt"/>
                <EditButton resource="user"/>
                <DeleteButton resource="user"/>
            </Datagrid>
        </List>
    )
}