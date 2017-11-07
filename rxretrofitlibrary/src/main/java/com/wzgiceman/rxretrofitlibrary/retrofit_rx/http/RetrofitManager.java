package com.wzgiceman.rxretrofitlibrary.retrofit_rx.http;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Administrator on 2017/8/21.
 * 单例模式
 */

public class RetrofitManager {
    private static RetrofitManager retrofitManager;
    private Retrofit retrofit;

    public Retrofit getRetrofit() {
        return retrofit;
    }

    private RetrofitManager(int connectTime,String baseUrl){
        initRetrofit(connectTime,baseUrl);
    }

    public static synchronized RetrofitManager getInstance(int connectTime,String baseUrl){
        if (retrofitManager == null){
            retrofitManager = new RetrofitManager(connectTime,baseUrl);
        }
        return retrofitManager;
    }


    private void initRetrofit(int connectTime,String baseUrl){
        //手动创建一个OkHttpClient并设置超时时间缓存等设置
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(connectTime, TimeUnit.SECONDS);
//        if (RxRetrofitApp.isDebug()) {
            builder.addInterceptor(getHttpLoggingInterceptor());
//        }

        /*创建retrofit对象*/
         retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();

    }

    /**
     * 日志输出
     * 自行判定是否添加
     *
     * @return
     */
    private HttpLoggingInterceptor getHttpLoggingInterceptor() {
        //日志显示级别
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("RxRetrofit", "Retrofit====Message:" + message);
            }
        });
        loggingInterceptor.setLevel(level);
        return loggingInterceptor;
    }

}
