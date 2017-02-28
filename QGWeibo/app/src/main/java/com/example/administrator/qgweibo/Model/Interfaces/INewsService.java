package com.example.administrator.qgweibo.Model.Interfaces;

import com.example.administrator.qgweibo.Model.Entities.News;

import java.util.List;

/**
 * Created by guochen on 2017/02/28.
 */
public interface INewsService {

    /**
     * ?用Api
     * @param url 新?api的url
     */
    public void getDataFromApi(String url);

    /**
     * ?取新?数据
     * @return 新?数据列表
     */
    public List<News> getNewsContents();
}
