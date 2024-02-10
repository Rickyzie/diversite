"use client"

export default function GlobalLayout ({
    children,
  }: Readonly<{
    children: React.ReactNode;
  }>){
    return (
      <div>{children}</div>
    )
}