package com.example.questdot.readcontentprovider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Uri URI = Uri.parse("content://com.example.questdot");
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView =(TextView)findViewById(R.id.textView);
        Cursor cursor = getContentResolver().query(URI, null, null, null, null);
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            String value = cursor.getString(cursor.getColumnIndex("name"));
            if(textView.getText().toString().isEmpty()){
                textView.setText(value);
            }
            else{
                textView.append(value);
            }

            cursor.moveToNext();
        }
    }

}
