package com.example.prototype;

import com.example.prototype.Model.Message;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/*
 * Created by LEnovo on 30/04/17.
 */

public interface API {
    @FormUrlEncoded
    @POST("loginForStudent.php")
    Call<Message> LoginForStudent(@Field("Username") String Username,
                        @Field("Password") String Password);


    @FormUrlEncoded
    @POST("loginForAdvisor.php")
    Call<Message> LoginForAdvisor(@Field("Username") String Username,
                                  @Field("Password") String Password);
}
