package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class IMCResult extends AppCompatActivity {
float peso,altura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcresult);
        peso = getIntent().getExtras().getFloat("keypeso");
        altura = getIntent().getExtras().getFloat("keyaltura");
        TextView tv = findViewById(R.id.tvImcResult);
        float imc = (peso / (altura * altura));
        tv.setText(Float.toString(imc));
        setPerfil(imc);
    }
    public void setPerfil(Float imc){
        ImageView imageView2=findViewById(R.id.imageView2);
        if (imc<18.5){
            imageView2.setImageResource(R.drawable.abaixopeso);

        }else{
            if (imc<25){
                imageView2.setImageResource(R.drawable.normal);
            }else{
                if (imc<30){
                    imageView2.setImageResource(R.drawable.sobrepeso);
                }else{
                    if (imc<35){
                        imageView2.setImageResource(R.drawable.obesidade1);
                    }else{
                        if (imc<40){
                            imageView2.setImageResource(R.drawable.obesidade2);
                        }else{
                            if (imc>40){
                                imageView2.setImageResource(R.drawable.obesidade3);


                            }

                        }
                    }

                }
            }
        }
    }
}