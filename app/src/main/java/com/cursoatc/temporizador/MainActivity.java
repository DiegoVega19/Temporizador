package com.cursoatc.temporizador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

  //Inicializo  Variables
    TextView textoTiempo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoTiempo = findViewById(R.id.tiempoText);

        //Inicializo la duracion del cronometro
        long duracion = TimeUnit.MINUTES.toMillis(1);

        //Inicializador del Contador de Tiempo
        new CountDownTimer(duracion, 1000) {
            @Override
            public void onTick(long l) {
                //Convertir milisegundos a minutos y segundos, cada que el cronometro pase

                String sDuration = String.format(Locale.ENGLISH, "%02d : %02d"
                        ,TimeUnit.MILLISECONDS.toMinutes(l)
                         , TimeUnit.MILLISECONDS.toSeconds(l) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                //Establecer el String Convertido en el Text View
                textoTiempo.setText(sDuration);
            }

            @Override
            public void onFinish() {
                //Cuando finaliza se oculta el text view y de igual manera se puede
                //Ubicar otro text view que diga game Over, aqui se programan los eventos que suceden
                //cuando el tiempo finaliza
                textoTiempo.setVisibility(View.GONE);
                //por cuestiones de prueba se desplazara un toast
                Toast.makeText(getApplicationContext(), "JUEGO TERMINADO SU TIEMPO SE ACABO", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }
}