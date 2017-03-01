package com.example.administrator.qgweibo.Presenter;

import android.content.Context;
import android.os.Handler;

import com.example.administrator.qgweibo.Const.Consts;
import com.example.administrator.qgweibo.Model.Entities.News;
import com.example.administrator.qgweibo.Model.Entities.NewsJson;
import com.example.administrator.qgweibo.Model.Interfaces.INewsService;
import com.example.administrator.qgweibo.Model.NetWorkServices.NewsService;
import com.example.administrator.qgweibo.View.Interfaces.NewsFragments.ITopNews;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by guochen on 2017/02/28.
 */
public class TopNewsPresenter {
    private INewsService newsService;
    private ITopNews topNews;
    private Gson gson = new Gson();

    public TopNewsPresenter(ITopNews topNews) {
        this.topNews = topNews;
        newsService = new NewsService();
    }

    /**
     * �W��?��V?������\
     */
    public void showListViewData()
    {
        newsService.getDataFromApi(Consts.TOP_NEWS_URL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            //onResponse方法是在工作线程中执行的
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonStr = response.body().string();
                NewsJson newsJson = gson.fromJson(jsonStr,NewsJson.class);
                topNews.showListViewContent(newsJson.getResult().getData());
            }
        });
    }
}
