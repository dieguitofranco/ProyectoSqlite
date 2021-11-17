package com.df.persistencia.Views.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.df.persistencia.Datos.dbPersonas;
import com.df.persistencia.Model.Carro;
import com.df.persistencia.Model.Persona;
import com.df.persistencia.R;
import com.df.persistencia.Views.Activities.Adapters.PersonaAdaptador;

import java.util.ArrayList;

public class Carros extends AppCompatActivity implements View.OnClickListener {

    private Button btnAddCar;
    private ListView listaCarro;
    dbPersonas dbc;
    ArrayList<Carro> carros;
    PersonaAdaptador carAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros);
        btnAddCar = findViewById(R.id.btnAddCarro);
        listaCarro = findViewById(R.id.lstViewCar);

        btnAddCar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnAddCarro:
                intent = new Intent(this, FormCarro.class);
                startActivity(intent);
                break;
        }
    }
}