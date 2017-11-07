package com.jstech.zhiyutong.http;

import java.util.Map;

import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/8/2.
 */

public interface HttpPostService {

    @GET("AppFiftyToneGraph/videoLink/{once_no}")
    Observable<String> getAllVedioBy(@Query("once_no") boolean once_no);

    @GET("index")
    Observable<String> get(@Query("name") String name);

    @GET("test/users")
    Observable<String> getUser();


    @FormUrlEncoded
    @POST("surveyor/slogin")
    Observable<String> login(@Field("name") String username, @Field("password") String password);



    @FormUrlEncoded
    @POST("surveyor/save")
    Observable<String> register(@FieldMap Map<String, String> map);


}
