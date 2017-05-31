package com.example.administrator.qgweibo.View.Activities

import android.app.Activity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.danxx.tabstrip.FlymeTabStrip
import com.example.administrator.qgweibo.Adapter.ViewPagerAdapter
import com.example.administrator.qgweibo.R
import com.example.administrator.qgweibo.View.CustomViews.CustomViewPager
import com.example.administrator.qgweibo.View.Interfaces.StarFragment.IStarDetailActivity

class StarDetailActivity : BaseActivity(), IStarDetailActivity {

    var tabStrip : FlymeTabStrip? = null
    var strArray = arrayOf("今日","明日","本周","下周","本月","今年")
    var viewPager : CustomViewPager? = null
    var drawableResIds = intArrayOf(R.mipmap.mm1, R.mipmap.mm2, R.mipmap.mm3, R.mipmap.mm4, R.mipmap.mm5, R.mipmap.mm6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_star_detail)
        initView()
    }

    override fun initView() {
        viewPager = findViewById(R.id.star_luck) as CustomViewPager
        tabStrip = findViewById(R.id.star_indicator) as FlymeTabStrip
        var luckAdapter = ViewPagerAdapter(this, drawableResIds, strArray)
        viewPager!!.adapter = luckAdapter
        tabStrip!!.setViewPager(viewPager)
    }
}
