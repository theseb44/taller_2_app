package com.example.taller2app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class codeActivity extends AppCompatActivity {


    Button cod, decod;
    TextView tex;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);

        tex = findViewById(R.id.texto2);
        text = findViewById(R.id.texto);
        cod = findViewById(R.id.codificar);
        decod = findViewById(R.id.decodificar);

        cod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tex.setText(codificarTexto(text.getText().toString()));
            }
        });

        decod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tex.setText(decodificarTexto(text.getText().toString()));
            }
        });


    }

    public String codificarTexto(String texto) {
        texto = texto.replaceAll("a", "@");
        texto = texto.replaceAll("e", "3");
        texto = texto.replaceAll("i", "1");
        texto = texto.replaceAll("o", "8");
        texto = texto.replaceAll("u", "5");
        texto = texto.replaceAll("m", "&");
        texto = texto.replaceAll("n", "(");
        texto = texto.replaceAll("p", ")");
        texto = texto.replaceAll("r", "#");
        return texto;
    }

    public String decodificarTexto(String texto) {
        texto = texto.replaceAll("@", "a");
        texto = texto.replaceAll("3", "e");
        texto = texto.replaceAll("1", "i");
        texto = texto.replaceAll("8", "o");
        texto = texto.replaceAll("5", "u");
        texto = texto.replaceAll("&", "m");
        texto = texto.replaceAll("\\(", "n");
        texto = texto.replaceAll("\\)", "p");
        texto = texto.replaceAll("#", "r");
        return texto;
    }
}