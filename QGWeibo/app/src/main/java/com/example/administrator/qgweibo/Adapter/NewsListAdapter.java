package com.example.administrator.qgweibo.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.qgweibo.Model.Entities.News;

import java.util.List;

/**
 * Created by guochen on 2017/02/27.
 */
public class NewsListAdapter extends BaseAdapter {
    private Context mContext;
    private List<News> mNewsList;
    private LayoutInflater layoutInflater;
    public NewsListAdapter(Context context, List<News> newsList) {
        this.mContext = context;
        this.mNewsList = newsList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mNewsList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(mContext);
        tv.setTextColor(Color.parseColor("#ff0000"));
        tv.setText(mNewsList.get(position).getTitle());
        return tv;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return mNewsList.get(position);
    }
}
