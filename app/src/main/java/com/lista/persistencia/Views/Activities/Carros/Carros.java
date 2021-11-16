package com.lista.persistencia.Views.Activities.Carros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.lista.persistencia.Datos.BaseDatosCarros;
import com.lista.persistencia.Datos.dbCarros;
import com.lista.persistencia.R;
import com.lista.persistencia.Views.Activities.Adapters.CarroAdaptador;


public class Carros extends AppCompatActivity implements View.OnClickListener {
    private Button btnCREAR;
    private ListView lstViewCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros);

        btnCREAR = findViewById(R.id.btnCREAR);
        lstViewCar = findViewById(R.id.activity_carros);

        btnCREAR.setOnClickListener(this);
        lstViewCar.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        BaseDatosCarros dbHelper = new BaseDatosCarros(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbCarros dbp = new dbCarros(db);
        CarroAdaptador carAdapter = new CarroAdaptador(this, dbp.insertCar());
        lstViewCar.setAdapter(carAdapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnCREAR:
                Intent intent = new Intent(this, FormularioCarros.class);
                startActivity(intent);
                break;
        }
    }





}