package com.example.hoang_tuan_thanh;

public class BaseResponse<Thanh> {
    private String status;
    private String message;
    private String access_token;
    private Thanh data;

    public BaseResponse() {
    }

    public BaseResponse(String status, String message, String access_token, Thanh data) {
        this.status = status;
        this.message = message;
        this.access_token = access_token;
        this.data = data;
    }

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

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Thanh getData() {
        return data;
    }

    public void setData(Thanh data) {
        this.data = data;
    }
}
