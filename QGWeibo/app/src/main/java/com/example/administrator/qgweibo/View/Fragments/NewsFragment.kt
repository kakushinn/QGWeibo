package com.example.administrator.qgweibo.View.Fragments

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.TextView

import com.example.administrator.qgweibo.Adapter.HomeViewPagerAdapter
import com.example.administrator.qgweibo.R
import com.example.administrator.qgweibo.View.Fragments.NewsFragments.DomesticNewsFragment
import com.example.administrator.qgweibo.View.Fragments.NewsFragments.EnjoymentNewsFragment
import com.example.administrator.qgweibo.View.Fragments.NewsFragments.FashionNewsFragment
import com.example.administrator.qgweibo.View.Fragments.NewsFragments.FinanceNewsFragment
import com.example.administrator.qgweibo.View.Fragments.NewsFragments.InternationalNewsFragment
import com.example.administrator.qgweibo.View.Fragments.NewsFragments.MilitaryNewsFragment
import com.example.administrator.qgweibo.View.Fragments.NewsFragments.SocialNewsFragment
import com.example.administrator.qgweibo.View.Fragments.NewsFragments.SportsNewsFragment
import com.example.administrator.qgweibo.View.Fragments.NewsFragments.TechnologyNewsFragment
import com.example.administrator.qgweibo.View.Fragments.NewsFragments.TopNewsFragment
import kotlinx.android.synthetic.main.fragment_home.*

import java.util.ArrayList

/**
 * Created by guochen on 2017/02/27.
 */
class NewsFragment : Fragment() {

    private var viewPager: ViewPager? = null
    private val fragmentList = ArrayList<Fragment>()
    private var navigationMenuLayout: LinearLayout? = null
    private var horizontalScrollView: HorizontalScrollView? = null
    private var currentIndex: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_home, null)
        initFragmentList()
        viewPager = view.findViewById(R.id.homeViewpager) as ViewPager
        navigationMenuLayout = view.findViewById(R.id.navigationMenuLayout) as LinearLayout
        horizontalScrollView = view.findViewById(R.id.scrollHorizontal) as HorizontalScrollView
        initTitleLayoutAction()
        val homeViewPagerAdapter = HomeViewPagerAdapter(childFragmentManager, fragmentList)
        viewPager!!.adapter = homeViewPagerAdapter
        viewPager!!.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                (navigationMenuLayout!!.getChildAt(position) as TextView).setTextColor(Color.parseColor("#ff0000"))
                (navigationMenuLayout!!.getChildAt(currentIndex) as TextView).setTextColor(Color.parseColor("#000000"))
                currentIndex = position
                if (position >= 5) {
                    horizontalScrollView!!.scrollTo(horizontalScrollView!!.width / 2, horizontalScrollView!!.y.toInt())
                } else {
                    horizontalScrollView!!.scrollTo(0, horizontalScrollView!!.y.toInt())
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
        return view
    }

    /**
     * 初始化view
     */
    private fun initFragmentList() {
        fragmentList.clear()
        val topNewsFragment = TopNewsFragment()
        val socialNewsFragment = SocialNewsFragment()
        val domesticNewsFragment = DomesticNewsFragment()
        val internationalNewsFragment = InternationalNewsFragment()
        val enjoymentNewsFragment = EnjoymentNewsFragment()
        val sportsNewsFragment = SportsNewsFragment()
        val militaryNewsFragment = MilitaryNewsFragment()
        val technologyNewsFragment = TechnologyNewsFragment()
        val financeNewsFragment = FinanceNewsFragment()
        val fashionNewsFragment = FashionNewsFragment()
        fragmentList.add(topNewsFragment)
        fragmentList.add(socialNewsFragment)
        fragmentList.add(domesticNewsFragment)
        fragmentList.add(internationalNewsFragment)
        fragmentList.add(enjoymentNewsFragment)
        fragmentList.add(sportsNewsFragment)
        fragmentList.add(militaryNewsFragment)
        fragmentList.add(technologyNewsFragment)
        fragmentList.add(financeNewsFragment)
        fragmentList.add(fashionNewsFragment)
    }

    /**
     * 设置导航栏点击事件
     */
    fun initTitleLayoutAction(){
        for (i in 0..navigationMenuLayout!!.childCount-1){
            (navigationMenuLayout!!.getChildAt(i) as TextView).setOnClickListener {
                viewPager!!.currentItem = i
                (navigationMenuLayout!!.getChildAt(i) as TextView).setTextColor(Color.parseColor("#ff0000"))
            }
        }
    }
}
