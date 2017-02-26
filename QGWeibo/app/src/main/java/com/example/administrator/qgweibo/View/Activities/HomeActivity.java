package com.example.administrator.qgweibo.View.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.RadioGroup;

import com.example.administrator.qgweibo.R;

/**
 * Created by Administrator on 2017/2/25.
 */
public class HomeActivity extends BaseActivity {

    public Toolbar homeToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homeToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(homeToolbar);
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
    }
}
