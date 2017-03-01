package com.example.administrator.qgweibo.Model.NetWorkServices;

import com.example.administrator.qgweibo.Adapter.NewsListAdapter;
import com.example.administrator.qgweibo.Const.Consts;
import com.example.administrator.qgweibo.Model.Entities.News;
import com.example.administrator.qgweibo.Model.Entities.NewsJson;
import com.example.administrator.qgweibo.Model.Interfaces.INewsService;
import com.example.administrator.qgweibo.View.Interfaces.NewsFragments.ITopNews;
import com.google.gson.Gson;
import com.zhy.http.okhttp.request.RequestCall;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
