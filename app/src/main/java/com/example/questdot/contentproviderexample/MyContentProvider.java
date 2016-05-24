package com.example.questdot.contentproviderexample;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    public MyContentProvider() {
    }

    public static final Uri URI = Uri.parse("content://com.example.questdot");

    SQLiteDatabase database;

    @Override
    public int delete(Uri arg0, String arg1, String[] arg2) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getType(Uri arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Uri insert(Uri arg0, ContentValues arg1) {
        database.insert("tab", "_id", arg1);
//		database.close();
        return null;
    }

    @Override
    public boolean onCreate() {
        database = getContext().openOrCreateDatabase("dbsample", Context.MODE_PRIVATE, null);
        database.execSQL("create table tab(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL)");

        return true;
    }

    @Override
    public Cursor query(Uri arg0, String[] arg1, String arg2, String[] arg3,
                        String arg4) {
        Cursor cursor = database.query("tab", null, null, null, null, null, null);
        return cursor;
    }

    @Override
    public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
        // TODO Auto-generated method stub
        return 0;
    }
}
