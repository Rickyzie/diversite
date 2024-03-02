/** @type {import('next').NextConfig} */
import path from "path";

const nextConfig = {
    sassOptions: {
        includePaths: [path.join("/", 'styles')],
    },
};

if (process.env.ENV_PROXY === "enable") {
    nextConfig.rewrites = async function(){
    return {
        fallback: [
        {
            source: '/:path*',
            destination: process.env.ENV_PROXY_API_URL, // Set the PROXY address
        },
        ],
    };
    }
}

export default nextConfig;
