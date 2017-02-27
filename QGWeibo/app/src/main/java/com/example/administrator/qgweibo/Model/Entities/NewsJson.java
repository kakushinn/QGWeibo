package com.example.administrator.qgweibo.Model.Entities;

/**
 * Created by guochen on 2017/02/27.
 */
public class NewsJson {

    public NewsJson() {
    }

    public NewsJson(String error_code, NewsResults result, String reason) {
        this.error_code = error_code;
        this.result = result;
        this.reason = reason;
    }

    private String reason;
    private NewsResults result;
    private String error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public NewsResults getResult() {
        return result;
    }

    public void setResult(NewsResults result) {
        this.result = result;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }
}
