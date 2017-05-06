package com.example.prototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prototype.Model.Message;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AcademicRequest extends AppCompatActivity {

    TextView code,id,gpa,section;
    RadioButton Accept,Reject,Contact;
    Button okey,cancal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_request);

        code=(TextView) findViewById(R.id.addRequest);
        id=(TextView) findViewById(R.id.studentID);
        gpa=(TextView) findViewById(R.id.gpa);
        section=(TextView) findViewById(R.id.SectionName);
        Accept=(RadioButton) findViewById(R.id.Accept_radioButton);
        Reject=(RadioButton) findViewById(R.id.Reject_radioButton);
        Contact=(RadioButton) findViewById(R.id.Contact_radioButton);
        okey=(Button) findViewById(R.id.okayButton);
        cancal=(Button) findViewById(R.id.cancelButton);

        final Intent info=getIntent();

        //to receive data from another activity
        code.setText(info.getStringExtra("opertion")+" - "+info.getStringExtra("code"));
        section.setText("Section : "+info.getStringExtra("section"));
        id.setText("Student ID : "+info.getStringExtra("id"));
        gpa.setText("GPA : "+info.getStringExtra("gpa"));

        cancal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        okey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String status;
                if(Accept.isChecked()){
                    status="Accept";
                }
                else if(Reject.isChecked()){
                    status="Reject";
                }
                else if(Contact.isChecked()){
                    status="Contact me";}
                else {
                    Log.d("test","tttt");
                    Toast.makeText(AcademicRequest.this,"Select a specific action: 'Accept,Reject,Contact' ",Toast.LENGTH_SHORT)
                            .show();
                    return;}


                Log.d("test","done");
                Retrofit.CreateRetrofitObj();

                final API API=Retrofit.getRetrofitObj()
                        .create(API.class);
                //for test
                Log.d("info",status+" : "+info.getStringExtra("number"));
                //send Number and Status to API and API send to PHP servier
                Call<Message> changeStats=API.changeStatus(info.getStringExtra("number"),
                        status);


                changeStats.enqueue(new Callback<Message>() {
                            @Override
                            public void onResponse(Call<Message> call, Response<Message> response) {
                                Log.d("Message", response.body().getMessage());

                                    finish();



                            }
                            @Override
                            public void onFailure(Call<Message> call, Throwable t) {
                                Log.d("error",t.getMessage());
                            }
                        }
                );

            }
        });






    }
}
