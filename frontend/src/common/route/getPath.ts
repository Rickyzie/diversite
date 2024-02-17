import PageRoute from "./PageRoute";
type GetPath = {
    route: PageRoute; 
    params?: Record<string, string | number>;
    queryParams?: Record<string, string | number>;
}
export default function getPath({
    route, 
    params, 
    queryParams
}: GetPath): string 
{
    let path = route as string;
    
    // Replace dynamic path segments
    if (params) {
        for (const [key, value] of Object.entries(params)) {
            path = path.replace(`:${key}`, encodeURIComponent(value.toString()));
        }
    }

    // Append query parameters
    if (queryParams && Object.keys(queryParams).length > 0) {
        const queryString = Object.entries(queryParams)
            .map(([key, value]) => `${encodeURIComponent(key)}=${encodeURIComponent(value)}`)
            .join('&');
            path += `?${queryString}`;
    }
    return path;
}
