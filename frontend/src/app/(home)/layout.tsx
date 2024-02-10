import { Inter } from "next/font/google";
import "../globals.css";
import { Metadata } from "next";
import GlobalLayout from "./globalLayout";

const inter = Inter({ subsets: ["latin"] });


export const metadata: Metadata = {
  title: "diversite",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body className={inter.className}>
        <GlobalLayout>
        {children}            
        </GlobalLayout>
      </body>
    </html>
  );
}
