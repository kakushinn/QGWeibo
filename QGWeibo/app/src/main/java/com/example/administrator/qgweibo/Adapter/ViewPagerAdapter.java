package com.example.administrator.qgweibo.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.qgweibo.R;

public class ViewPagerAdapter extends PagerAdapter
    {
        private Context mContext;
        private int[] drawableResIds;
        private String[] titles;
        public ViewPagerAdapter(Context mContext, int[] drawableResIds, String[] titles) {
            this.mContext = mContext;
            this.drawableResIds = drawableResIds;
            this.titles = titles;
        }

        @Override
        public int getCount() {
            return drawableResIds.length;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {
            ImageView imageView = (ImageView) LayoutInflater.from(mContext).inflate(R.layout.image_display, null);
            imageView.setImageResource(drawableResIds[position]);
            imageView.setTag(position);
            container.addView(imageView);

            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object)
        {
            ImageView image = (ImageView)((ViewPager) container).findViewWithTag(position);
            ((ViewPager) container).removeView(image);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1)
        {
            return arg0==arg1;
        }

        @Override
        public CharSequence getPageTitle(int position) {
//            return super.getPageTitle(position);
            return titles[position];
        }


    }