type SuccessApiReturnType<T> = {
    status: "success";
    data: T;
};

type ErrorApiReturnType = {
    status: "error";
    message: string;
};

export type ApiReturnType<T> = SuccessApiReturnType<T> | ErrorApiReturnType;

