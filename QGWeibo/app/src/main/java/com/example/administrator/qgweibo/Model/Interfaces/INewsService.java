package com.example.administrator.qgweibo.Model.Interfaces;

import com.example.administrator.qgweibo.Model.Entities.News;

import java.util.List;

/**
 * Created by guochen on 2017/02/28.
 */
public interface INewsService {

    /**
     * ?�pApi
     * @param url �V?api�Iurl
     */
    public void getDataFromApi(String url);

    /**
     * ?��V?����
     * @return �V?������\
     */
    public List<News> getNewsContents();
}
