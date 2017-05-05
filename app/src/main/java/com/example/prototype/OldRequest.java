package com.example.prototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.prototype.Model.GetNewRq4AD;
import com.example.prototype.Model.GetOldReq4AD;
import com.example.prototype.adpter.newrequestAdpter;
import com.example.prototype.adpter.oldrequestAdpter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OldRequest extends AppCompatActivity {

    RecyclerView reques2;
    ArrayList<GetOldReq4AD> items2=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_request);

        Retrofit.CreateRetrofitObj();

        final API API=Retrofit.getRetrofitObj()
                .create(API.class);

    Call<List<GetOldReq4AD>> oldRqCall=API.GetListOldReq(SaveInfo.getID());

        oldRqCall.enqueue(new Callback<List<GetOldReq4AD>>() {
            @Override
            public void onResponse(Call<List<GetOldReq4AD>> call, Response<List<GetOldReq4AD>> response) {
                List<GetOldReq4AD> oldReq4ADs=response.body();
                for(int i=0;i<oldReq4ADs.size();i++){
                    items2.add(oldReq4ADs.get(i));
                }
                reques2= (RecyclerView) findViewById(R.id.request_old);
                reques2.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                oldrequestAdpter adpter2=new oldrequestAdpter(items2,getApplicationContext());
                reques2.setAdapter(adpter2);
            }

            @Override
            public void onFailure(Call<List<GetOldReq4AD>> call, Throwable t) {

            }
        });
    }
}
