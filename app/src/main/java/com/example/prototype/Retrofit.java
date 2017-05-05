package com.example.prototype;

import retrofit2.converter.gson.GsonConverterFactory;

/*
 * Created by LEnovo on 30/04/17.
 */

public class Retrofit {
    private static retrofit2.Retrofit RetrofitObj=null;
    public static void CreateRetrofitObj(){
        retrofit2.Retrofit retrofit=new retrofit2.Retrofit.Builder()
                .baseUrl("http://192.168.1.23:82/gproject/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitObj=retrofit;

    }
    public static retrofit2.Retrofit getRetrofitObj(){return RetrofitObj;}
}
