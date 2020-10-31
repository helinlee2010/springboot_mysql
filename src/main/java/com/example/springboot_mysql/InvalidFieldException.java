package com.example.springboot_mysql;

public class InvalidFieldException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String message;

    public InvalidFieldException(String msg){
        this.setMessage(msg);
    }

    @Override
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
