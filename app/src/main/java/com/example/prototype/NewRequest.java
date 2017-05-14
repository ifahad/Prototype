package com.example.prototype;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.prototype.adpter.newrequestAdpter;
import com.example.prototype.Model.GetNewRq4AD;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewRequest extends AppCompatActivity {
    RecyclerView reques;
    ArrayList<GetNewRq4AD> items=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_request);

        Retrofit.CreateRetrofitObj();

        final API API=Retrofit.getRetrofitObj()
                .create(API.class);

        Call<List<GetNewRq4AD>> newRqCall=API.GetListNewReq(SaveInfo.getID());

        newRqCall.enqueue(new Callback<List<GetNewRq4AD>>() {
            @Override
            public void onResponse(Call<List<GetNewRq4AD>> call, Response<List<GetNewRq4AD>> response) {
                //write this (List<GetNewRq4AD>) becuose I receve list from server.
                List<GetNewRq4AD> newRq4ADs=response.body();
                for(int i=0;i<newRq4ADs.size();i++){
                    items.add(newRq4ADs.get(i));
                }
                reques= (RecyclerView) findViewById(R.id.reqest_new);
                reques.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                newrequestAdpter adpter=new newrequestAdpter(items,getApplicationContext());
                reques.setAdapter(adpter);
            }

            @Override
            public void onFailure(Call<List<GetNewRq4AD>> call, Throwable t) {

            }
        });


    }


}

