package com.df.persistencia.Views.Activities.Activities;

import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.appcompat.app.AppCompatActivity;

import com.df.persistencia.R;

public class CrearCarro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_carro);
        DisplayMetrics medidas =  new DisplayMetrics();//Describe información general sobre una pantalla
        getWindowManager().getDefaultDisplay().getMetrics(medidas);
        int ancho = medidas.widthPixels;
        int alto = medidas.heightPixels;
        getWindow().setLayout((int) (ancho*0.8), (int)(alto*0.60));
    }
}