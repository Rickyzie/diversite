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
                    backgroundColor:"#302d2d"
                }
            }
        }
    },
    palette: {
        background:{
            default:  "#302d2d"
        },
        text: {
            primary: "#fff"
        },
        primary: {
        light: '#ee9c9d',
        main: '#ef5756',
        dark: '#e53f3c',
        contrastText: '#fff',
        
        },
        secondary: {
        light: '#a9a5a5',
        main: '#605d5d',
        dark: '#302d2d',
        contrastText: '#fff',
        },
    },
});
