package com.jstech.zhiyutong.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.bigkoo.convenientbanner.ConvenientBanner;


/**
 * Created by Administrator on 2017/8/15.
 * 解决recyclerView添加header 轮播图出现上下左右滑动冲突
 */

public class MyConvenientBanner extends ConvenientBanner {

    float mDownX;
    float mDownY;

    public MyConvenientBanner(Context context) {
        super(context);
    }

    public MyConvenientBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyConvenientBanner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyConvenientBanner(Context context, AttributeSet attrs, int defStyleAttr, int
            defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //DOWN 事件的时候记录下当前的xy左标
                mDownX=ev.getX();
                mDownY=ev.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
            /*MOVE 事件后计算x轴y轴的移动距离 ，如果x轴移动距离大于y轴，
            那么该事件有ViewPager处理，否则交给父容器处理*/
                if(Math.abs(ev.getX()-mDownX)>Math.abs(ev.getY()-mDownY)){
                    getParent().requestDisallowInterceptTouchEvent(true);
                }else{
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            case MotionEvent.ACTION_CANCEL:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

}
