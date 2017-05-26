package com.example.administrator.qgweibo.View.Activities

import android.app.Activity
import android.os.Bundle
import com.example.administrator.qgweibo.R
import com.example.administrator.qgweibo.View.Interfaces.StarFragment.IStarDetailActivity

class StarDetailActivity : BaseActivity(), IStarDetailActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_star_detail)
    }

    override fun initView() {

    }
}
