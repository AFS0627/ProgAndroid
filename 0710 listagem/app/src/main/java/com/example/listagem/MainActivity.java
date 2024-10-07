package com.example.listagem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String[] nomes = new String[] {"picareta, nome, peco"};
            ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewFindById(R.id.listView);
        ArrayAdapter.arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1);
        android.R.Id.texti.
                nomes
                );
        listView.setAdapter(ArrayAdapter);
    }
}