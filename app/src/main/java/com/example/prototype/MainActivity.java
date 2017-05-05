package com.example.prototype;

import android.content.Intent;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.prototype.Model.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button login;
    RadioButton student;
    RadioButton advisor;
    EditText username_edit;
    EditText password_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initComponent();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(student.isChecked()){
                    Retrofit.CreateRetrofitObj();

                    final API LoginAPI=Retrofit.getRetrofitObj()
                            .create(API.class);

                    Call<Message> LoginCall=LoginAPI.LoginForStudent(
                            username_edit.getText().toString(),
                            password_edit.getText().toString()
                    );

                    LoginCall.enqueue(new Callback<Message>() {
                        @Override
                        public void onResponse(Call<Message> call, Response<Message> response) {

                            Log.d("response",response.body().getMessage());
                            if(response.body().getMessage().equals("yes")) {
                                //for save ID becuse maybe needs when send the Request
                                SaveInfo.setID(username_edit.getText().toString());
                                Log.d("ID",SaveInfo.getID());
                                //go to next screen for student
                                Intent stud_intent = new Intent(getApplicationContext(), StudentPortal.class);
                                startActivity(stud_intent);
                                finish();

                            } else {
                                Toast.makeText(MainActivity.this,"Username Or Password is Failed",Toast.LENGTH_SHORT)
                                        .show();
                            }

                        }

                        @Override
                        public void onFailure(Call<Message> call, Throwable t) {
                            Log.d("response",t.getMessage());
                            Toast.makeText(MainActivity.this,"Connection Failed",Toast.LENGTH_SHORT)
                                    .show();
                        }
                    });

                }
                else if(advisor.isChecked()) {
                    //Toast.makeText(MainActivity.this,"advisor",Toast.LENGTH_SHORT).show();
                    Retrofit.CreateRetrofitObj();

                    final API LoginAPI=Retrofit.getRetrofitObj()
                            .create(API.class);

                    Call<Message> LoginCall=LoginAPI.LoginForAdvisor(
                            username_edit.getText().toString(),
                            password_edit.getText().toString()
                    );

                    LoginCall.enqueue(new Callback<Message>() {
                        @Override
                        public void onResponse(Call<Message> call, Response<Message> response) {
                            Log.d("response",response.body().getMessage());
                            if(response.body().getMessage().equals("yes")) {
                                //for save ID
                                SaveInfo.setID(username_edit.getText().toString());
                                Log.d("ID",SaveInfo.getID());
                                //go to next screen for Advisor
                                Intent advi_intent = new Intent(getApplicationContext(), AcademicAdvisorPortal.class);
                                startActivity(advi_intent);

                               finish();
                            } else {
                                Toast.makeText(MainActivity.this,"Username Or Password is Failed",Toast.LENGTH_SHORT)
                                        .show();
                            }

                        }

                        @Override
                        public void onFailure(Call<Message> call, Throwable t) {
                            Log.d("response",t.getMessage());
                            Toast.makeText(MainActivity.this,"Connection Failed",Toast.LENGTH_SHORT)
                                    .show();

                        }
                    });



                }

            }
        });


        
    }
    public void initComponent(){
        //ref
        login= (Button) findViewById(R.id.Login_btn);
        student= (RadioButton) findViewById(R.id.Rd_student);
        advisor= (RadioButton) findViewById(R.id.Red_aca);
        username_edit= (EditText) findViewById(R.id.username);
        password_edit= (EditText) findViewById(R.id.password);

        // set value
        student.setChecked(true);
    }


}
