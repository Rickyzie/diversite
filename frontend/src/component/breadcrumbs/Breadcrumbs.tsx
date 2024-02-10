import { Breadcrumbs as MuiBreadcrumbs, Link as MuiLink, Typography } from "@mui/material";
import Link from "next/link";
type BreadcrumbInfo = {
    text: string,
    src: string,
}

export default function Breadcrumbs({
    BreadcrumbInfos
}:{
    BreadcrumbInfos:BreadcrumbInfo[],
}){
    return (
        <>
            <MuiBreadcrumbs aria-label="breadcrumb" color="text.primary">
                {BreadcrumbInfos.map(({text, src}, index) => {

                    if(BreadcrumbInfos.length - 1 !== index){
                        return (
                            <Link
                                href={src}
                            >
                                <MuiLink underline="hover" color="text.primary">
                                    {text}
                                </MuiLink>
                            </Link>
                        )
                    }else{
                        return (
                            <Typography color="text.primary">text</Typography>
                        )
                        
                    }
                })}
            </MuiBreadcrumbs>
        </>
    )
}