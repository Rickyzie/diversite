import { Datagrid, List, NumberField, Show, SimpleShowLayout, TextField } from "react-admin";

export default function UserList(){
    return (
        <List>
            <Datagrid>
                <NumberField source="id" />
                <TextField source="name" />
                <TextField source="phoneNumber"/>
                <TextField source="address"/>
                <TextField source="createdAt"/>
                <TextField source="updatedAt"/>
            </Datagrid>
        </List>
    )
}