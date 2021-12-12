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
import com.df.persistencia.R;
import com.df.persistencia.Views.Activities.Adapters.CarrosAdaptador;

import java.util.ArrayList;

public class Carros extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private Button btnAgregar;
    private ListView listCarros;
    dbCarros dbc;
    ArrayList<Carro> Carros;
    CarrosAdaptador carAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros);
        btnAgregar = findViewById(R.id.btnAgregar);
        listCarros = findViewById(R.id.listCarros);
        btnAgregar.setOnClickListener(this);
        listCarros.setOnItemClickListener(this);
        listCarros.setOnItemLongClickListener(this);
    }
    @Override
    protected void onStart() {
        super.onStart();
        ActualizarCarro();
    }
    public void ActualizarCarro(){
        BaseDatosCarros dbHelper = new BaseDatosCarros(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbc = new dbCarros(db);
        Carros =dbc.obtenerCarros();
        carAdapter = new CarrosAdaptador(this,Carros);
        listCarros.setAdapter(carAdapter);
    }
    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnAgregar:
                intent = new Intent(this, FormularioCarros.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Ha seleccionado el carro: " , Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
        dbc.deleteCarro(Carros.get(position).getId());
        ActualizarCarro();
        return false;

    }
}