package com.example.jiandaoapp.net.api;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;


/**
 * 这个代码不用动了
 */
public interface NetApi {

    @GET
    Observable<ResponseBody> get(@Url String url);

    @GET
    Observable<ResponseBody> get(@Url String url, @QueryMap HashMap<String,String> queryMap);


    @GET
    Observable<ResponseBody> post(@Url String url);

    @GET
    Observable<ResponseBody> post(@Url String url, @QueryMap HashMap<String,String> queryMap);



}
