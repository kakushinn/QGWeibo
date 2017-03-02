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

import java.util.List;

/**
 * Created by guochen on 2017/02/27.
 */
public class MilitaryNewsFragment extends Fragment implements NetworkStateService.DoWhenDisconnected,INewsFragment {
    public static NetworkStateService.DoWhenDisconnected event;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    private NewsPresenter presenter;
    private List<News> newses;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        event = this;
        presenter = new NewsPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_listview, null);
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipeRefreshLayout);
        listView = (ListView)view.findViewById(R.id.newsListView);
        presenter.showListViewData(Consts.MILITARY_NEWS_URL);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(newses != null && newses.size() > 0){
                    UiUtils.openNewsContent(newses.get(i).getUrl(),getContext());
                }
            }
        });
        return view;
    }

    /**
     * DoSth when network changed
     * @param networkValid  whether network is valid
     */
    @Override
    public void doChange(boolean networkValid) {
        if(networkValid){
            presenter.showListViewData(Consts.TOP_NEWS_URL);
        }
    }


    /**
     * show the news in listview
     * @param newsList 新?内容list
     */
    @Override
    public void showListViewContent(final List<News> newsList) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (newsList != null && newsList.size() > 0) {
                    newses = newsList;
                    NewsListAdapter adapter = new NewsListAdapter(getContext(), newsList);
                    listView.setAdapter(adapter);
                }
            }
        });

    }
}
