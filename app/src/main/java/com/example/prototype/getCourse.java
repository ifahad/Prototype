package com.example.prototype;

import android.util.Log;

import com.example.prototype.Model.Message;
import com.example.prototype.Model.code;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LEnovo on 02/05/17.
 */

public class getCourse {
  private static  List<String> Course;

    public static List<String> getCourse() {
        return Course;
    }

    public static void getCourseFormServer() {
        if (Course == null) {
            Course=new ArrayList<>();
            Retrofit.CreateRetrofitObj();
            final API API = Retrofit.getRetrofitObj()
                    .create(API.class);

            Call<List<code>> getCourcseCall = API.GetCourse();
            getCourcseCall.enqueue(new Callback<List<code>>() {
                @Override
                public void onResponse(Call<List<code>> call, Response<List<code>> response) {
                    List<code> courses = response.body();

                    for (int i = 0; i < courses.size(); i++) {
                        Course.add(courses.get(i).getCode());
                        Log.d("code", courses.get(i).getCode());
                    }
                }

                @Override
                public void onFailure(Call<List<code>> call, Throwable t) {
                    Log.d("error", t.getMessage());
                }
            });
        }
    }

}
