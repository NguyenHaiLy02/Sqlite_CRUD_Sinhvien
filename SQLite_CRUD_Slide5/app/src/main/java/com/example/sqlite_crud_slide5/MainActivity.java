package com.example.sqlite_crud_slide5;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.sqlite_crud_slide5.sqlite.DBHelped;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelped dbHelped = new DBHelped(this);
        SQLiteDatabase database = dbHelped.getReadableDatabase();
        database.close();
    }
}