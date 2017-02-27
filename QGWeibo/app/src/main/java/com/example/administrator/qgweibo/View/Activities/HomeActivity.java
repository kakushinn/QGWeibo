package com.example.administrator.qgweibo.View.Activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.qgweibo.R;
import com.example.administrator.qgweibo.View.Fragments.MovieFragment;
import com.example.administrator.qgweibo.View.Fragments.NewsFragment;
import com.example.administrator.qgweibo.View.Fragments.StarFragment;
import com.example.administrator.qgweibo.View.Fragments.VideoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/25.
 */
public class HomeActivity extends BaseActivity{

    public Toolbar homeToolbar;
//    public HorizontalScrollView scrollHorizontal;
    private FrameLayout frameLayout;
    private RadioGroup radioGroup;
    private RadioButton homeRadioButton;
    private RadioButton videoRadioButton;
    private RadioButton starRadioButton;
    private RadioButton movieRadioButton;
    private List<Fragment> fragments = new ArrayList<Fragment>();
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homeToolbar = (Toolbar) findViewById(R.id.toolbar);
        initLayout();
        initFragments();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.indexGroupBtn:
                        setSelectedIndex(0);
                        break;
                    case R.id.videoGroupBtn:
                        setSelectedIndex(1);
                        break;
                    case R.id.starGroupBtn:
                        setSelectedIndex(2);
                        break;
                    case R.id.movieGroupBtn:
                        setSelectedIndex(3);
                        break;
                    default:
                        break;
                }
            }
        });
//        scrollHorizontal = (HorizontalScrollView)findViewById(R.id.scrollHorizontal);
//        int width = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
//        int height = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
//        scrollHorizontal.measure(width,height);
//        scrollHorizontal.post(new Runnable() {
//            @Override
//            public void run() {
//                scrollHorizontal.   scrollTo(scrollHorizontal.getMeasuredWidth(),scrollHorizontal.getMeasuredHeight());
//            }
//        });
//        int a = scrollHorizontal.getMeasuredWidth();
//        int b = scrollHorizontal.getMeasuredHeight();
    }

    /**
     * 初始化Layout
     */
    private void initLayout(){
        frameLayout = (FrameLayout)findViewById(R.id.frameLayout);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        homeRadioButton = (RadioButton)findViewById(R.id.indexGroupBtn);
        videoRadioButton = (RadioButton)findViewById(R.id.videoGroupBtn);
        starRadioButton = (RadioButton)findViewById(R.id.starGroupBtn);
        movieRadioButton = (RadioButton)findViewById(R.id.movieGroupBtn);
    }

    /**
     * 初始化fragment的?示
     */
    private void initFragments(){
        fragments.clear();
        NewsFragment newsFragment = new NewsFragment();
        MovieFragment movieFragment = new MovieFragment();
        StarFragment starFragment = new StarFragment();
        VideoFragment videoFragment = new VideoFragment();
        fragments.add(newsFragment);
        fragments.add(videoFragment);
        fragments.add(starFragment);
        fragments.add(movieFragment);
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frameLayout,newsFragment).commit();
        setSelectedIndex(0);
    }


    /**
     * ?置?示的fragment
     * @param mIndex  fragment所在fragmentList中的位置
     */
    private void setSelectedIndex(int mIndex){
        if(mIndex ==  currentIndex){
            return;
        }
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.hide(fragments.get(currentIndex));
        if(fragments.get(mIndex).isAdded()){
            ft.show(fragments.get(mIndex));
        }else{
            ft.add(R.id.frameLayout,fragments.get(mIndex)).show(fragments.get(mIndex));
        }
        ft.commit();
        currentIndex = mIndex;
    }
}
