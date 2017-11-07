package com.jstech.zhiyutong.api;

import com.jstech.zhiyutong.http.HttpPostService;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.BaseApi;

import java.util.Map;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by Administrator on 2017/8/2.
 */

public class SubjectPostregisterApi extends BaseApi {

    private Map<String,String>map;

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    /**
     * 默认初始化需要给定初始设置
     * 可以额外设置请求设置加载框显示，回调等（可扩展）
     * 设置可查看BaseApi
     */
    public SubjectPostregisterApi() {
        setCache(false);
        setMethod("surveyor/save");
    }


    @Override
    public Observable getObservable(Retrofit retrofit) {
        HttpPostService httpService = retrofit.create(HttpPostService.class);
        return httpService.register(getMap());
    }

}
