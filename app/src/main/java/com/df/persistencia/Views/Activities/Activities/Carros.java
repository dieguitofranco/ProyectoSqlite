package com.df.persistencia.Views.Activities.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.df.persistencia.R;

public class Carros extends AppCompatActivity implements View.OnClickListener {
    private Button btnAddNewCar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros);

        btnAddNewCar = findViewById(R.id.addNewCar);
        btnAddNewCar.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        startActivity(new Intent(Carros.this, CrearCarro.class));
    }
}