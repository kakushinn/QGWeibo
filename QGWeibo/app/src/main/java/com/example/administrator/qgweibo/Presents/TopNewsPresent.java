package com.example.administrator.qgweibo.Presents;

import com.example.administrator.qgweibo.Const.Consts;
import com.example.administrator.qgweibo.Model.Entities.News;
import com.example.administrator.qgweibo.Model.Interfaces.INewsService;
import com.example.administrator.qgweibo.Model.NetWorkServices.NewsService;
import com.example.administrator.qgweibo.View.Interfaces.NewsFragments.ITopNews;

import java.util.List;

/**
 * Created by guochen on 2017/02/28.
 */
public class TopNewsPresent {
    private INewsService newsService;
    private ITopNews topNews;

    public TopNewsPresent(ITopNews topNews) {
        this.topNews = topNews;
        newsService = new NewsService();
    }

    /**
     * ìWé¶?èêV?êîêòóÒï\
     */
    public void showListViewData()
    {
        newsService.getDataFromApi(Consts.TOP_NEWS_URL);
        List<News> newsList = newsService.getNewsContents();
//        if(newsList != null && newsList.size() > 0) {
//            topNews.showListViewContent(newsService.getNewsContents());
//        }
    }
}
