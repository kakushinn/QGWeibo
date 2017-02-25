package com.example.administrator.qgweibo.View.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.example.administrator.qgweibo.R;
import com.example.administrator.qgweibo.View.Interfaces.ISplash;

/**
 * Created by Administrator on 2017/2/15.
 */
public class SplashActivity extends Activity implements ISplash {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        showSplashImage();
    }

    @Override
    public void showSplashImage() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        },2000);
    }
}
