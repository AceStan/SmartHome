package com.example.aleksandar.raspberrycommunication;

/**
 * Created by Aleksandar on 13.03.2016.
 */
public class MyResponse {
    String success;
    String message;
    int status;

    public int getStatus() { return status; }

    public void setStatus(int status) { this.status = status ;}

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
