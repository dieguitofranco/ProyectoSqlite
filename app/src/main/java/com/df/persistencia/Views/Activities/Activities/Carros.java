package com.df.persistencia.Views.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.df.persistencia.Datos.BaseDatosCarros;
import com.df.persistencia.Datos.dbCarros;
import com.df.persistencia.Model.Carro;
import com.df.persistencia.Model.Persona;
import com.df.persistencia.R;
import com.df.persistencia.Views.Activities.Adapters.CarroAdapter;
import com.df.persistencia.Views.Activities.Adapters.PersonaAdaptador;

import java.util.ArrayList;

public class Carros extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private Button btnAddCar;
    private ListView listaCarro;
    dbCarros dbc;
    ArrayList<Carro> carros;
    CarroAdapter carAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros);
        btnAddCar = findViewById(R.id.btnAddCarro);
        listaCarro = findViewById(R.id.lstViewCar);

        btnAddCar.setOnClickListener(this);
        listaCarro.setOnItemClickListener(this);
        listaCarro.setOnItemLongClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateElements();
    }

    public void updateElements(){
        BaseDatosCarros dbHelper = new BaseDatosCarros(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbc = new dbCarros(db);
        carros = dbc.obtenerCarros();
        carAdapter = new CarroAdapter(this, carros);
        listaCarro.setAdapter(carAdapter);
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Carro  carroSelect = carros.get(i);
        Toast.makeText(this, "Ha seleccionado el carro: " + carroSelect.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        Carro  carroSelect = carros.get(i);
        Toast.makeText(this, "Se ha eliminado el carro: " + carroSelect.getName(), Toast.LENGTH_SHORT).show();
        dbc.deleteCar(carros.get(i).getId());
        updateElements();
        return false;
    }
}