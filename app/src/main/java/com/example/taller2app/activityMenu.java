package com.example.taller2app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activityMenu extends AppCompatActivity {


    Button ventanaCro, ventanaCod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ventanaCro = (Button) findViewById(R.id.cronometro);
        ventanaCod = (Button) findViewById(R.id.codigo);

        ventanaCod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ventanaCodigo();
            }
        });

        ventanaCro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ventanaCronometro();
            }
        });

    }


    public void ventanaCronometro(){
        Intent i = new Intent(activityMenu.this,CronoActivity.class);
        startActivity(i);
    }

    public void ventanaCodigo(){
        Intent i = new Intent(activityMenu.this,codeActivity.class);
        startActivity(i);
    }
}