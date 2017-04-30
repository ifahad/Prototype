package com.example.prototype;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StudentPortal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_portal);
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
}


