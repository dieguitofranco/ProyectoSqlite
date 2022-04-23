package com.df.persistencia.Views.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.df.persistencia.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences preferencias;
    EditText txtName;
    Button btnPersonas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPersonas = findViewById(R.id.btnPersonas);
        btnPersonas.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnPersonas){
            Intent intent = new Intent(MainActivity.this,  Personas.class);
            startActivity(intent);

        }
    }
}