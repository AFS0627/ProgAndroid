package com.example.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.ContentValues;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
SQLiteDatabase database;
EditText editTextNome,editTextEmail,editTextDtNsc;
Button button;
ListView listview;
    ArrayList<String> nomes;
    ArrayList<Integer> ids;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNome = findViewById(R.id.edNome);
        editTextEmail = findViewById(R.id.edEmail);
        editTextDtNsc = findViewById(R.id.edNascimento);
        button = findViewById(R.id.buttonCadastrar);
        listview = findViewById(R.id.listview);
        nomes = new ArrayList<>();
        ids = new ArrayList<>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                String data = editTextDtNsc.getText().toString();
                ContentValues cv = new ContentValues();
                cv.put("nome", nome);
                cv.put("email", email);
                cv.put("dtnsc", data);
                long status = database.insert("pessoas", null, cv);
                if (status > 0) {
                    Toast.makeText(getApplicationContext(), "Usuario cadastrado", Toast.LENGTH_LONG).show();
                    editTextNome.setText("");
                    editTextEmail.setText("");
                    editTextDtNsc.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Erro na inserção!", Toast.LENGTH_LONG).show();
                }
                carregar();
            }
        });
        database = openOrCreateDatabase("meubd", MODE_PRIVATE, null);

        database.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT,nome varchar, email varchar, dtnsc DATE)");
        listview.setOnItemClickListener((parent, view, position, id) -> preencherCampos(ids.get(position)));

    }
        public void carregar(){
Cursor cursor=database.rawQuery("select * from pessoas" ,null);
cursor.moveToFirst();

    ArrayList<String> nomes= new ArrayList<>();
            while (cursor.moveToNext()) {
                nomes.add(cursor.getString(1)); // Nome
                ids.add(cursor.getInt(0)); // ID


    }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nomes);
            listview.setAdapter(adapter);
    }
    private void preencherCampos(int userId) {
        Cursor cursor = database.rawQuery("SELECT * FROM pessoas WHERE id = ?", new String[]{String.valueOf(userId)});
        if (cursor.moveToFirst()) {
            editTextNome.setText(cursor.getString(1));
            editTextEmail.setText(cursor.getString(2));
            editTextDtNsc.setText(cursor.getString(3));
        }
    }
}