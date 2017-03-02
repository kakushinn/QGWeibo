package com.example.administrator.qgweibo.Model.NetWorkServices;

import com.example.administrator.qgweibo.Model.Interfaces.INewsService;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;


/**
 * Created by guochen on 2017/02/28.
 */
public class NewsService implements INewsService {

    @Override
    public void getDataFromApi(String url, Callback callback){
        OkHttpClient mOkHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(callback);
    }
}
