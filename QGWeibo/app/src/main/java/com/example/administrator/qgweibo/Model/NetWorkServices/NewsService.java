package com.example.administrator.qgweibo.Model.NetWorkServices;

import com.example.administrator.qgweibo.Adapter.NewsListAdapter;
import com.example.administrator.qgweibo.Const.Consts;
import com.example.administrator.qgweibo.Model.Entities.News;
import com.example.administrator.qgweibo.Model.Entities.NewsJson;
import com.example.administrator.qgweibo.Model.Interfaces.INewsService;
import com.example.administrator.qgweibo.View.Interfaces.NewsFragments.ITopNews;
import com.google.gson.Gson;

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
    private List<News> newsContents;

    /**
     * ?取新?数据
     * @return 新?数据列表
     */
    @Override
    public List<News> getNewsContents() {
        return newsContents;
    }

    public void setNewsContents(List<News> newsContents) {
        this.newsContents = newsContents;
    }

    /**
     * ?取新?列表数据
     * @param url 新?api的url
     */
    @Override
    public void getDataFromApi(String url) {
        OkHttpClient mOkHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonStr = response.body().string();
                Gson gson = new Gson();
                final NewsJson newsJson = gson.fromJson(jsonStr,NewsJson.class);
                setNewsContents(newsJson.getResult().getData());
            }
        });
    }
}
