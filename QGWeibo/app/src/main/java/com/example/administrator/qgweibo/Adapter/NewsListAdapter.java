package com.example.administrator.qgweibo.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.qgweibo.Model.Entities.News;
import com.example.administrator.qgweibo.R;

import org.w3c.dom.Text;

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
        ViewHolder holder;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.item_listview_top,null);
            holder = new ViewHolder();
            holder.news_title_view = (TextView)convertView.findViewById(R.id.news_title);
            holder.news_from_view = (TextView)convertView.findViewById(R.id.news_from);
            holder.news_date_view = (TextView)convertView.findViewById(R.id.news_date);
            holder.news_image_view = (ImageView)convertView.findViewById(R.id.news_image);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        holder.news_title_view.setText(mNewsList.get(position).getTitle());
        holder.news_from_view.setText(mNewsList.get(position).getAuthor_name());
        holder.news_date_view.setText(mNewsList.get(position).getDate());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return mNewsList.get(position);
    }

    static class ViewHolder{
        TextView news_title_view;
        TextView news_from_view;
        TextView news_date_view;
        ImageView news_image_view;
    }
}
