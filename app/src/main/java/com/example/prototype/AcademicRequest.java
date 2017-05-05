package com.example.prototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AcademicRequest extends AppCompatActivity {
    TextView code,id,gpa,section;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_request);

        code=(TextView) findViewById(R.id.addRequest);
        id=(TextView) findViewById(R.id.studentID);
        gpa=(TextView) findViewById(R.id.gpa);
        section=(TextView) findViewById(R.id.SectionName);

        Intent info=getIntent();

        code.setText(info.getStringExtra("opertion")+" - "+info.getStringExtra("code"));
        section.setText("Section : "+info.getStringExtra("section"));
        id.setText("ID : "+info.getStringExtra("id"));
        gpa.setText("GPA : "+info.getStringExtra("gpa"));

    }
}
