package com.diversite.response;

public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;

    // Constructor for success response
    public ApiResponse(T data) {
        this.status = "success";
        this.message = null;
        this.data = data;
    }

    // Constructor for error response
    public ApiResponse(String message) {
        this.status = "error";
        this.message = message;
        this.data = null;
    }

    // Getters and setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
