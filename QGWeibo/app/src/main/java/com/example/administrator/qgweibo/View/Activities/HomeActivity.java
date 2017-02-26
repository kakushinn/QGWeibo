package com.example.administrator.qgweibo.View.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.RadioGroup;

import com.example.administrator.qgweibo.R;

/**
 * Created by Administrator on 2017/2/25.
 */
public class HomeActivity extends BaseActivity {

    public Toolbar homeToolbar;
    public HorizontalScrollView scrollHorizontal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homeToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(homeToolbar);
        scrollHorizontal = (HorizontalScrollView)findViewById(R.id.scrollHorizontal);
        int width = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        int height = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        scrollHorizontal.measure(width,height);
        scrollHorizontal.post(new Runnable() {
            @Override
            public void run() {
                scrollHorizontal.   scrollTo(scrollHorizontal.getMeasuredWidth(),scrollHorizontal.getMeasuredHeight());
            }
        });
        int a = scrollHorizontal.getMeasuredWidth();
        int b = scrollHorizontal.getMeasuredHeight();
    }
}
