package com.example.administrator.qgweibo.View.Interfaces.NewsFragments;

import com.example.administrator.qgweibo.Model.Entities.News;

import java.util.List;

/**
 * Created by guochen on 2017/02/28.
 */
public interface ITopNews {

    /**
     * ?示列表内容
     * @param  newsList 新?内容list
     */
    public void showListViewContent(List<News> newsList);
}
