"use client"

import Image from "next/image";
import Carousel from "react-material-ui-carousel";
import { Button, Link as MuiLink, Paper, Typography } from "@mui/material";
import Breadcrumbs from "../../component/breadcrumbs/Breadcrumbs";


function Item({ item }: {item: string})
{
    return (
        <Paper
          sx={{
            width:"100%",
            height:"300px"
          }}
        >
            <Image
              src={item}
              alt="banner"
              layout="fill"
              objectFit="cover"
            />
        </Paper>
    )
}

export default function Home() {
  const items = [
    {
      src: "/images/banner01.webp",
    },
    {
      src: "/images/banner02.webp",
    }
]

return (
    <Carousel>
        {
            items.map( (item, i) => <Item key={i} item={item.src} /> )
        }
    </Carousel>
)
}
