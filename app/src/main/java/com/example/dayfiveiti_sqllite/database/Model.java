package com.example.dayfiveiti_sqllite.database;

public class Model {
    private String message,phone;

    public Model(String message, String phone) {
        this.message = message;
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
