package com.jstech.zhiyutong;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Environment;
import android.support.annotation.Nullable;

import com.jstech.zhiyutong.utils.SystemUtil;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.RxRetrofitApp;

/**
 * Created by shilongfei on 2017/8/31.
 */

public class InitializeService  extends IntentService{

    private static final String ACTION_INIT_WHEN_APP_CREATE = "com.service.action.INIT";

    public InitializeService() {
        super("InitializeService");
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, InitializeService.class);
        intent.setAction(ACTION_INIT_WHEN_APP_CREATE);
        context.startService(intent);
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_INIT_WHEN_APP_CREATE.equals(action)) {
                performInit();
            }
        }

    }

    /**
     * 初始化第三方启动
     */
    private void performInit() {

        RxRetrofitApp.init(this.getApplication());

    }

    public static boolean inMainProcess(Context context) {
        String packageName = context.getPackageName();
        String processName = SystemUtil.getProcessName(context);
        return packageName.equals(processName);
    }

}
