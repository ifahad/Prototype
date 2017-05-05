package com.example.prototype;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class AcademicAdvisorPortal extends AppCompatActivity {


    private long backPressedTimeB = 0;    // used by onBackPressed()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_advisor_portal);
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_advisor_portal);

        // my_child_toolbar is defined in the layout file
        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.my_child_toolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
    }*/


    public void goNewActivity(View view)
    {
        Intent intent = new Intent(AcademicAdvisorPortal.this, NewRequest.class);
        startActivity(intent);
    }

    public void goOldActivity(View view)
    {
        Intent intent = new Intent(AcademicAdvisorPortal.this, OldRequest.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        long t = System.currentTimeMillis();
        if (t - backPressedTimeB > 2000) {    // 2 secs
            backPressedTimeB = t;
            Toast.makeText(AcademicAdvisorPortal.this, "Press back again to Exit",Toast.LENGTH_SHORT).show();
        } else {    // this guy is serious
            // clean up
            super.onBackPressed();       // bye
        }
    }
}
