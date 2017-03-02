package com.example.administrator.qgweibo.View.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.qgweibo.Adapter.HomeViewPagerAdapter;
import com.example.administrator.qgweibo.R;
import com.example.administrator.qgweibo.View.Fragments.NewsFragments.DomesticNewsFragment;
import com.example.administrator.qgweibo.View.Fragments.NewsFragments.EnjoymentNewsFragment;
import com.example.administrator.qgweibo.View.Fragments.NewsFragments.FashionNewsFragment;
import com.example.administrator.qgweibo.View.Fragments.NewsFragments.FinanceNewsFragment;
import com.example.administrator.qgweibo.View.Fragments.NewsFragments.InternationalNewsFragment;
import com.example.administrator.qgweibo.View.Fragments.NewsFragments.MilitaryNewsFragment;
import com.example.administrator.qgweibo.View.Fragments.NewsFragments.SocialNewsFragment;
import com.example.administrator.qgweibo.View.Fragments.NewsFragments.SportsNewsFragment;
import com.example.administrator.qgweibo.View.Fragments.NewsFragments.TechnologyNewsFragment;
import com.example.administrator.qgweibo.View.Fragments.NewsFragments.TopNewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guochen on 2017/02/27.
 */
public class NewsFragment extends Fragment {

    private ViewPager viewPager;
    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private LinearLayout navigationMenuLayout;
    private HorizontalScrollView horizontalScrollView;
    private int currentIndex;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,null);
        initFragmentList();
        viewPager = (ViewPager)view.findViewById(R.id.homeViewpager);
        navigationMenuLayout = (LinearLayout)view.findViewById(R.id.navigationMenuLayout);
        horizontalScrollView = (HorizontalScrollView)view.findViewById(R.id.scrollHorizontal);
        HomeViewPagerAdapter homeViewPagerAdapter = new HomeViewPagerAdapter(getChildFragmentManager(),fragmentList);
        viewPager.setAdapter(homeViewPagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((TextView)(navigationMenuLayout.getChildAt(position))).setTextColor(Color.parseColor("#ff0000"));
                ((TextView)(navigationMenuLayout.getChildAt(currentIndex))).setTextColor(Color.parseColor("#000000"));
                currentIndex = position;
                if(position >= 5){
                    horizontalScrollView.scrollTo(horizontalScrollView.getWidth()/2,(int)(horizontalScrollView.getY()));
                }else{
                    horizontalScrollView.scrollTo(0,(int)(horizontalScrollView.getY()));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

    private void initFragmentList(){
        fragmentList.clear();
        TopNewsFragment topNewsFragment = new TopNewsFragment();
        SocialNewsFragment socialNewsFragment = new SocialNewsFragment();
        DomesticNewsFragment domesticNewsFragment = new DomesticNewsFragment();
        InternationalNewsFragment internationalNewsFragment = new InternationalNewsFragment();
        EnjoymentNewsFragment enjoymentNewsFragment = new EnjoymentNewsFragment();
        SportsNewsFragment sportsNewsFragment = new SportsNewsFragment();
        MilitaryNewsFragment militaryNewsFragment = new MilitaryNewsFragment();
        TechnologyNewsFragment technologyNewsFragment = new TechnologyNewsFragment();
        FinanceNewsFragment financeNewsFragment = new FinanceNewsFragment();
        FashionNewsFragment fashionNewsFragment = new FashionNewsFragment();
        fragmentList.add(topNewsFragment);
        fragmentList.add(socialNewsFragment);
        fragmentList.add(domesticNewsFragment);
        fragmentList.add(internationalNewsFragment);
        fragmentList.add(enjoymentNewsFragment);
        fragmentList.add(sportsNewsFragment);
        fragmentList.add(militaryNewsFragment);
        fragmentList.add(technologyNewsFragment);
        fragmentList.add(financeNewsFragment);
        fragmentList.add(fashionNewsFragment);
    }



}
