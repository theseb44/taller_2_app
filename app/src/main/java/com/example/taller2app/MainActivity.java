package com.example.taller2app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    EditText num1x,num1y,num2x,num2y;
    float x1,y1,x2,y2;
    Button calcular,sig,aleatorio;
    TextView result;
    Spinner options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aleatorio = findViewById(R.id.aleatorio);
        sig = findViewById(R.id.siguiente);
        num1x = (EditText) findViewById(R.id.x1);
        num1y = (EditText) findViewById(R.id.y1);
        num2x = (EditText) findViewById(R.id.x2);
        num2y = (EditText) findViewById(R.id.y2);
        result = (TextView) findViewById(R.id.resultado);
        calcular = findViewById(R.id.button);
        options = findViewById(R.id.opciones);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.operaciones, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        options.setAdapter(adapter);
        int op = options.getSelectedItemPosition();


        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x1 = Float.parseFloat(num1x.getText().toString());
                y1 = Float.parseFloat(num1y.getText().toString());
                x2 = Float.parseFloat(num2x.getText().toString());
                y2 = Float.parseFloat(num2y.getText().toString());

                calculo(x1,y1,x2,y2, op);
            }
        });

        aleatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x1 = (float) Math.random();
                y1 = (float) Math.random();
                x2 = (float) Math.random();
                y2 = (float) Math.random();
                calculo(x1,y1,x2,y2,op);
            }
        });


        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,activityMenu.class);
                startActivity(i);
            }
        });
    }



    public void calculo(float x1,float y1,float x2,float y2, int op){
        try {
            switch(op){
                case 0:
                    double diferenciaX = x2 - x1;
                    double diferenciaY = y2 - y1;
                    double x = Math.sqrt(Math.pow(diferenciaX, 2) + Math.pow(diferenciaY, 2));
                    result.setText(x + "");
                    break;
                case 1:
                    if (x1 == x2) {

                        result.setText("La pendiente es indefinida ya que los puntos tienen la misma coordenada x.");
                    } else {
                        result.setText(((y2 - y1) / (x2 - x1)) + "");
                    }
                    break;
                case 2:
                    double xm = (x1 + x2) / 2;
                    double ym = (y1 + y2) / 2;
                    result.setText("("+xm + "," + ym+")");
                    break;
            }


        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}