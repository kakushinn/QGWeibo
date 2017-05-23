package com.example.administrator.qgweibo.View.Activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView

import com.example.administrator.qgweibo.R
import com.example.administrator.qgweibo.View.Interfaces.ISplash

/**
 * Created by Administrator on 2017/2/15.
 */
class SplashActivity : Activity(), ISplash {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        showSplashImage()
    }

    override fun showSplashImage() {
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }, 2000)
    }
}
