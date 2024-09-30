package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edAltura,edPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edAltura=findViewById(R.id.edAltura);
        edPeso=findViewById(R.id.edPeso);
        (findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float peso=Float.parseFloat(edPeso.getText().toString());
                Float altura=Float.parseFloat((edAltura.getText().toString()));

                Intent i = new Intent(getApplicationContext(),IMCResult.class);
                i.putExtra("keypeso",peso);
                i.putExtra("keyaltura",altura);

                startActivity(i);
            }
        });
    }
}