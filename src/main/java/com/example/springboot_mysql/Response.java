package com.example.springboot_mysql;

public class Response {
    private String message;
    private boolean success;

    public Response() {
    }

    public Response(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "Response{" +
                "message='" + message + '\'' +
                ", success=" + success +
                '}';
    }
}
