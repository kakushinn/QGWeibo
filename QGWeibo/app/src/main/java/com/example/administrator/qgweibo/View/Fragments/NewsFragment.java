package com.example.administrator.qgweibo.View.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.qgweibo.Adapter.HomeViewPagerAdapter;
import com.example.administrator.qgweibo.R;
import com.example.administrator.qgweibo.View.Fragments.NewsFragments.TopNewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guochen on 2017/02/27.
 */
public class NewsFragment extends Fragment {

    private ViewPager viewPager;
    private List<Fragment> fragmentList = new ArrayList<Fragment>();

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
        HomeViewPagerAdapter homeViewPagerAdapter = new HomeViewPagerAdapter(getChildFragmentManager(),fragmentList);
        viewPager.setAdapter(homeViewPagerAdapter);
        return view;
    }

    private void initFragmentList(){
        fragmentList.clear();
        TopNewsFragment topNewsFragment = new TopNewsFragment();
        VideoFragment videoFragment2 = new VideoFragment();
        fragmentList.add(topNewsFragment);
        fragmentList.add(videoFragment2);
    }



}
