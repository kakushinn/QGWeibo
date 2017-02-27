package com.example.administrator.qgweibo.Model.Entities;

import java.util.List;

/**
 * Created by guochen on 2017/02/27.
 */
public class NewsResults {
    public NewsResults() {
    }

    public NewsResults(String stat, List<News> data) {
        this.stat = stat;
        this.data = data;
    }

    private String stat;
    private List<News> data;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<News> getData() {
        return data;
    }

    public void setData(List<News> data) {
        this.data = data;
    }
}
