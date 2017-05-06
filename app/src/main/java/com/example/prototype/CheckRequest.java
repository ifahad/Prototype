package com.example.prototype;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.prototype.Model.Message;
import com.example.prototype.adpter.ListReqforStdAdpter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Leopard on 4/30/2017.
 */

public class CheckRequest extends Activity {
    RecyclerView listitem;
    ArrayList<Message> messages=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_request);
        listitem= (RecyclerView) findViewById(R.id.listReqStd);

        listitem.setLayoutManager(new LinearLayoutManager(this));

        Retrofit.CreateRetrofitObj();

        final API API=Retrofit.getRetrofitObj()
                .create(API.class);

        Call<List<Message>> changeStats=API.SendID4Std(SaveInfo.getID());

        changeStats.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                List<Message> items=response.body();
                for(int i=0;i<items.size();i++){
                    messages.add(items.get(i));
                    Log.d("text",items.get(i).getMessage());
                }
                ListReqforStdAdpter adpter=new ListReqforStdAdpter(messages);
                listitem.setAdapter(adpter);

            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                Log.d("message",t.getMessage());

            }
        });
    }
}
