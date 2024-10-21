package com.example.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database=openOrCreateDatabase("meubd",MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE pessoas (id INT PRIMARY KEY AUTOINCREMENT,nome varchar, email varchar, dtnsc DATE)");

    }
}