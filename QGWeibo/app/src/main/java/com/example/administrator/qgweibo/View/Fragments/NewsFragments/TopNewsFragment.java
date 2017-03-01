package com.example.administrator.qgweibo.View.Fragments.NewsFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.qgweibo.Adapter.NewsListAdapter;
import com.example.administrator.qgweibo.Model.Entities.News;
import com.example.administrator.qgweibo.Presenter.TopNewsPresenter;
import com.example.administrator.qgweibo.R;
import com.example.administrator.qgweibo.Service.NetworkStateService;
import com.example.administrator.qgweibo.View.Interfaces.NewsFragments.ITopNews;

import java.util.List;

/**
 * Created by guochen on 2017/02/27.
 */
public class TopNewsFragment extends Fragment implements NetworkStateService.DoWhenDisconnected,ITopNews{
    public static NetworkStateService.DoWhenDisconnected event;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    private TopNewsPresenter presenter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        event = this;
        presenter = new TopNewsPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_listview, null);
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipeRefreshLayout);
        listView = (ListView)view.findViewById(R.id.newsListView);
        presenter.showListViewData();
        return view;
    }

    @Override
    public void doChange(boolean networkValid) {
        if(networkValid){
            presenter.showListViewData();
        }
    }

    @Override
    public void showListViewContent(final List<News> newsList) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                NewsListAdapter adapter = new NewsListAdapter(getContext(),newsList);
                listView.setAdapter(adapter);
            }
        });

    }
}
