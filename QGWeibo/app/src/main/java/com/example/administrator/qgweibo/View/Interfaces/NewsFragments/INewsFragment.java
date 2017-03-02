package com.example.administrator.qgweibo.View.Interfaces.NewsFragments;

import com.example.administrator.qgweibo.Model.Entities.News;

import java.util.List;

/**
 * Created by guochen on 2017/02/28.
 */
public interface INewsFragment {

    /**
     * show news content
     * @param  newsList  list for news
     */
    public void showListViewContent(List<News> newsList);
}
