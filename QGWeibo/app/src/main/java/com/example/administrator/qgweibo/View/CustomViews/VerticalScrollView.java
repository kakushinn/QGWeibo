package com.example.administrator.qgweibo.View.CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2017/5/31.
 */

public class VerticalScrollView extends ScrollView {
    private GestureDetector gestureDetector;

    public VerticalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        gestureDetector = new GestureDetector(context, new YScrollDetector());
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev) && gestureDetector.onTouchEvent(ev);
    }

    class YScrollDetector extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {
            /**
             * 如果我们滚动更接近水平方向,返回false,让子视图来处理它
             */
            return (Math.abs(distanceY) > Math.abs(distanceX));
        }
    }
}
