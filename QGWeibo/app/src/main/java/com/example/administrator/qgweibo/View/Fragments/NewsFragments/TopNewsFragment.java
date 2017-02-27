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
import com.example.administrator.qgweibo.Model.Entities.NewsJson;
import com.example.administrator.qgweibo.R;
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
public class TopNewsFragment extends Fragment {

    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_listview,null);
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipeRefreshLayout);
        listView = (ListView)view.findViewById(R.id.newsListView);
        OkHttpClient mOkHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://v.juhe.cn/toutiao/index?type=top&key=b69cc2e92edc5b582eba0a94c51173c8").build();
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
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        NewsListAdapter adapter = new NewsListAdapter(getContext(),newsJson.getResult().getData());
                        listView.setAdapter(adapter);
                    }
                });
            }

        });
        return view;
    }
}
