package com.example.administrator.qgweibo.Model.Interfaces;

import com.example.administrator.qgweibo.Model.Entities.News;

import java.io.IOException;
import java.util.List;

import okhttp3.Callback;

/**
 * Created by guochen on 2017/02/28.
 */
public interface INewsService {

    /**
     * ?�pApi
     * @param url �V?api�Iurl
     */
    public void getDataFromApi(String url, Callback callback);

}
