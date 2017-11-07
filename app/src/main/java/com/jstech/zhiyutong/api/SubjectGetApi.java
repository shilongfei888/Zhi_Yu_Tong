package com.jstech.zhiyutong.api;

import com.jstech.zhiyutong.http.HttpPostService;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.BaseApi;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by Administrator on 2017/8/2.
 */

public class SubjectGetApi extends BaseApi {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    /**
     * 默认初始化需要给定初始设置
     * 可以额外设置请求设置加载框显示，回调等（可扩展）
     * 设置可查看BaseApi
     */
    public SubjectGetApi() {
        setCache(false);
        setMethod("index");
    }


    @Override
    public Observable getObservable(Retrofit retrofit) {
        HttpPostService httpService = retrofit.create(HttpPostService.class);
        return httpService.get(getName());
    }

}
