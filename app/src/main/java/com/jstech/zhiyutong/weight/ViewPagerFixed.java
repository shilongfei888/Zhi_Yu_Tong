package com.jstech.zhiyutong.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 修复viewpager
 */
public class ViewPagerFixed extends android.support.v4.view.ViewPager {

    private boolean notTouchScoll = false;

    public ViewPagerFixed(Context context) {
        super(context);
    }

    public ViewPagerFixed(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setNotTouchScoll(boolean scoll) {
        this.notTouchScoll = scoll;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (notTouchScoll) {
            return false;
        }
        try {
            return super.onTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (notTouchScoll) {
            return false;
        }
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
