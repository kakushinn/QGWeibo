package com.example.administrator.qgweibo.View.Fragments.NewsFragments;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.qgweibo.Adapter.NewsListAdapter;
import com.example.administrator.qgweibo.Const.Consts;
import com.example.administrator.qgweibo.Model.Entities.News;
import com.example.administrator.qgweibo.Model.Entities.NewsJson;
import com.example.administrator.qgweibo.Model.Interfaces.INewsService;
import com.example.administrator.qgweibo.Model.NetWorkServices.NewsService;
import com.example.administrator.qgweibo.Presents.TopNewsPresent;
import com.example.administrator.qgweibo.R;
import com.example.administrator.qgweibo.Service.NetworkStateService;
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
 * Created by guochen on 2017/02/27.
 */
public class TopNewsFragment extends Fragment implements NetworkStateService.DoWhenDisconnected,ITopNews{
    public static NetworkStateService.DoWhenDisconnected event;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    private TopNewsPresent present;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        event = this;
        present = new TopNewsPresent(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_listview, null);
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipeRefreshLayout);
        listView = (ListView)view.findViewById(R.id.newsListView);
        present.showListViewData();
        return view;
    }

    @Override
    public void doChange(boolean networkValid) {
        if(networkValid){
            present.showListViewData();
        }
    }

    @Override
    public void showListViewContent(List<News> newsList) {
        NewsListAdapter adapter = new NewsListAdapter(getContext(),newsList);
        listView.setAdapter(adapter);
    }
}
