"use client"

import Topbar from "../../component/topbar/Topbar";
import Container from "@mui/material/Container";
import { ThemeProvider } from "@emotion/react";
import theme from "../../component/theme/theme"
import CssBaseline from "@mui/material/CssBaseline";
import StoreProvider from "./lib/StoreProvider";

export default function GlobalLayout ({
    children,
  }: Readonly<{
    children: React.ReactNode;
  }>){
    return (
        <ThemeProvider theme={theme}>
            <CssBaseline enableColorScheme />
            <Topbar/>
            <Container maxWidth="xl">
              <StoreProvider>
                {children} 
              </StoreProvider>
            </Container>
        </ThemeProvider>
    )
}