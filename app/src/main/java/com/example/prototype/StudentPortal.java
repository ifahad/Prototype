package com.example.prototype;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class StudentPortal extends AppCompatActivity {


    private long backPressedTimeA = 0;    // used by onBackPressed()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_portal);

        getCourse.getCourseFormServer();



    }



    // Add request navigation page
    public void goToAddRequest(View view) {
        Intent intent = new Intent(StudentPortal.this, AddRequest.class);
        startActivity(intent);
    }

    // Delete request navigation page
    public void goToDeleteRequest(View view) {
        Intent intent = new Intent(StudentPortal.this, DeleteRequest.class);
        startActivity(intent);
    }

    // Withdrawal request navigation page
    public void goToWithdrawRequest(View view) {
        Intent intent = new Intent(StudentPortal.this, WithdrawalRequest.class);
        startActivity(intent);
    }

    // Check request navigation page
    public void goToCheckRequest(View view) {
        Intent intent = new Intent(StudentPortal.this, CheckRequest.class);
        startActivity(intent);
    }






    @Override
    public void onBackPressed() {     // to prevent irritating accidental logouts
        long t = System.currentTimeMillis();
        if (t - backPressedTimeA > 2000) {    // 2 secs
            backPressedTimeA = t;
            Toast.makeText(StudentPortal.this, "Press back again to Exit",Toast.LENGTH_SHORT).show();
        } else {    // this guy is serious
            // clean up
            super.onBackPressed();       // bye
        }
    }
}


