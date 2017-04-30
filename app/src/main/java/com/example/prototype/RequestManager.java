package com.example.prototype;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Leopard on 4/26/2017.
 */

public class RequestManager extends Activity {


}


class ListNewRequest extends Activity {

    // Array of Strings
    String[] newRequest = {"Delete CS, 331", "Add CS, 211", "Add IS, 45"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_request);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_new_request, newRequest);
        ListView listView = (ListView) findViewById(R.id.newRequestList);
        listView.setAdapter(adapter);
    }
}

class ListOldRequest extends Activity {

    // Array of Strings
    String[] oldRequest = {"Delete CS, 331", "Add CS, 211", "Add IS, 45"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_request);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_old_request, oldRequest);
        ListView listView = (ListView) findViewById(R.id.oldRequestList);
        listView.setAdapter(adapter);
    }

    public class NewRequest extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_new_request);
        }


    }
}
