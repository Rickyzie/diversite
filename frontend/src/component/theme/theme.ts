import darkScrollbar from "@mui/material/darkScrollbar";
import { createTheme } from "@mui/material/styles";
declare module '@mui/material/styles' {
    interface PaletteColor {
      darker?: string;
    }
  
    interface SimplePaletteColorOptions {
      darker?: string;
    }
  }
export default createTheme({
    components: {
        MuiPaper: {
            styleOverrides: {
                root: {
                }
            }
        }
    },
    palette: {
        background:{
            default:  "#141618"
        },
        text: {
            primary: "#fff"
        },
        primary: {
            light: '#c82825',
            main: '#ac1412',
            dark: '#0d0d0f',
            contrastText: "#fff",
        },
        
    },
});
