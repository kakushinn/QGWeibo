package com.example.administrator.qgweibo.Utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.example.administrator.qgweibo.View.Activities.NewsWebViewActivity;

/**
 * Created by guochen on 2017/03/02.
 */
public class UiUtils {

    /**
     * open webview to load news url
     * @param url  news url
     */
    public static void openNewsContent(String url, Context context){
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse(url));
//        context.startActivity(intent);
        Intent intent = new Intent(context, NewsWebViewActivity.class);
        intent.putExtra("newsUrl", url);
        context.startActivity(intent);
    }
}
