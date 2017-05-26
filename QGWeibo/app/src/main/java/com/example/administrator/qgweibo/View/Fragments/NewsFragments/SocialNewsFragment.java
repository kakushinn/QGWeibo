package com.example.administrator.qgweibo.View.Fragments.NewsFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.qgweibo.Adapter.NewsListAdapter;
import com.example.administrator.qgweibo.Const.Consts;
import com.example.administrator.qgweibo.Model.Entities.News;
import com.example.administrator.qgweibo.Presenter.NewsPresenter;
import com.example.administrator.qgweibo.R;
import com.example.administrator.qgweibo.Service.NetworkStateService;
import com.example.administrator.qgweibo.Utils.UiUtils;
import com.example.administrator.qgweibo.View.Interfaces.NewsFragments.INewsFragment;
import com.yalantis.phoenix.PullToRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guochen on 2017/03/02.
 */
public class SocialNewsFragment extends Fragment implements INewsFragment,NetworkStateService.DoWhenDisconnected {
    public static NetworkStateService.DoWhenDisconnected event;
    private NewsPresenter presenter;
    private PullToRefreshView refreshView;
    private ListView listView;
    private View view;
    private List<News> newses = new ArrayList<News>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        event = this;
        presenter = new NewsPresenter(this);
    }

    @Override
    public void doChange(boolean networkValid) {
        if(true){
            presenter = new NewsPresenter(this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_listview,null);
        refreshView = (PullToRefreshView) view.findViewById(R.id.pull_to_refresh);
        listView = (ListView)view.findViewById(R.id.newsListView);
        presenter.showListViewData(Consts.SOCIAL_NEWS_URL);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(newses.size() > 0){
                    UiUtils.INSTANCE.openNewsContent(newses.get(position).getUrl(),getContext());
                }
            }
        });
        refreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener(){
            @Override
            public void onRefresh() {
                presenter.showListViewData(Consts.TOP_NEWS_URL);
            }
        });
        return view;
    }

    @Override
    public void showListViewContent(final List<News> newsList) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(newsList != null && newsList.size() > 0){
                    newses = newsList;
                    NewsListAdapter adapter = new NewsListAdapter(getContext(),newsList);
                    listView.setAdapter(adapter);
                    refreshView.setRefreshing(false);
                }
            }
        });
    }
}
