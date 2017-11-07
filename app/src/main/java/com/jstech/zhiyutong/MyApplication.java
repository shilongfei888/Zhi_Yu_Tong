package com.jstech.zhiyutong;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/8/3.
 */

public class MyApplication extends Application {

    private static Context context;

    //返回
    public static Context getApplication(){
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        context=getApplicationContext();

        /**
         * 初始化第三方
         */
        InitializeService.start(this);

    }

}
