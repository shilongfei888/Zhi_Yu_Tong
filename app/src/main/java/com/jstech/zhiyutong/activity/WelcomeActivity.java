package com.jstech.zhiyutong.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.jstech.zhiyutong.R;
import com.jstech.zhiyutong.base.BaseActivity;


public class WelcomeActivity extends BaseActivity{

    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView() {

        handler=new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
                finish();
            }
        },2000);

    }

}
