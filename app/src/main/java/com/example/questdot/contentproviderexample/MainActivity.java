package com.example.questdot.contentproviderexample;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                write();
                Toast.makeText(getApplicationContext(), "Successfully write into content provider", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void write() {
        ContentValues values;
        values = new ContentValues();
        values.put("name", "Java");
        getContentResolver().insert(MyContentProvider.URI, values);

    }
}
