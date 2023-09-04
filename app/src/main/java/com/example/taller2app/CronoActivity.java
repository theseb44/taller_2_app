package com.example.taller2app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CronoActivity extends AppCompatActivity {


    Button iniciar,detener,continuar,reiniciar;
    int segundos;
    Boolean encendido;

    Handler handler;

    TextView timerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crono);

        timerText = findViewById(R.id.timer);
        iniciar = findViewById(R.id.iniciar);
        detener = findViewById(R.id.detener);
        continuar = findViewById(R.id.continuar);
        reiniciar = findViewById(R.id.resetear);
        handler = new Handler();

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });

        detener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTimer();
            }
        });

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resumeTimer();
            }
        });

        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
    }

    public void startTimer() {
        encendido = true;
        iniciar.setEnabled(false);
        detener.setEnabled(true);
        continuar.setEnabled(false);
        reiniciar.setEnabled(true);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (encendido) {
                    segundos++;
                    updateTimerText();
                    handler.postDelayed(this, 1000);
                }
            }
        }, 1000);
    }

    public void stopTimer() {
        encendido = false;
        iniciar.setEnabled(false);
        detener.setEnabled(false);
        continuar.setEnabled(true);
        reiniciar.setEnabled(true);

    }

    public void resumeTimer() {
        startTimer();
        iniciar.setEnabled(false);
        detener.setEnabled(true);
        continuar.setEnabled(false);
        reiniciar.setEnabled(true);
    }

    public void resetTimer() {
        encendido = false;
        segundos = 0;
        timerText.setText("00:00:00");
        updateTimerText();
        iniciar.setEnabled(true);
        detener.setEnabled(false);
        continuar.setEnabled(false);
        reiniciar.setEnabled(false);
    }

    private void updateTimerText() {
        int hours = segundos / 3600;
        int minutes = (segundos % 3600) / 60;
        int secs = segundos % 60;

        String time = String.format("%02d:%02d:%02d", hours, minutes, secs);
        timerText.setText(time);
    }
}