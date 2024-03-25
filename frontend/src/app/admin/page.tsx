"use client"
import {
    Admin,
    CustomRoutes,
    Resource,
    localStorageStore,
    useStore,
    StoreContextProvider,
    DataProvider,
    RaRecord,
    Identifier,
    GetListParams,
    GetListResult,
} from 'react-admin';
import { Route } from 'react-router';

import authProvider from './authProvider';
import categories from './categories';
import invoices from './invoices';
import { Layout, Login } from './layoutComponent';
import orders from './orders';
import products from './products';
import users from './users';
import Segments from './segments/Segments';
import visitors from './visitors';
import { themes, ThemeName } from './themes/themes';
import adminDataProvider from './adminDataProvider';







const store = localStorageStore(undefined, 'ECommerce');

const App = () => {
    const [themeName] = useStore<ThemeName>('themeName', 'soft');
    const lightTheme = themes.find(theme => theme.name === themeName)?.light;
    const darkTheme = themes.find(theme => theme.name === themeName)?.dark;
    return (
        <Admin
            title=""
            store={store}
            dataProvider={adminDataProvider}
            authProvider={authProvider}
            loginPage={Login}
            layout={Layout}
            disableTelemetry
            lightTheme={lightTheme}
            darkTheme={darkTheme}
            defaultTheme="light"
        >
            <Resource name="user" {...users} />
        </Admin>
    );
};

const AppWrapper = () => (
    <StoreContextProvider value={store}>
        <App />
    </StoreContextProvider>
);

export default AppWrapper;