package com.example.prototype;

import com.example.prototype.Model.GetNewRq4AD;
import com.example.prototype.Model.GetOldReq4AD;
import com.example.prototype.Model.Message;
import com.example.prototype.Model.code;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
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


    @GET("ListOfCourses.php")
    Call<List<code>> GetCourse();

    @FormUrlEncoded
    @POST("RequestOpretion.php")
    Call<Message> Add_Delete_Operation(@Field("type") String type,
                               @Field("id") String id,
                               @Field("code") String code,
                               @Field("section") String section);


    @FormUrlEncoded
    @POST("RequestOpretion_withdrw.php")
    Call<Message> Withdraw_Operation(@Field("type") String type,
                                       @Field("id") String id,
                                       @Field("code") String code,
                                       @Field("section") String section,
                                        @Field("reason") String reason);

    @FormUrlEncoded
    @POST("ListNewReqForAD.php")
    Call<List<GetNewRq4AD>> GetListNewReq(@Field("adv_id") String adv_id);



    @FormUrlEncoded
    @POST("ListOldReqForAD.php")
    Call<List<GetOldReq4AD>> GetListOldReq(@Field("adv_id") String adv_id);



}
