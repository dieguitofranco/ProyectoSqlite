package com.df.persistencia.Views.Activities.Activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.df.persistencia.Datos.BaseDatosCarros;
import com.df.persistencia.Datos.dbCarros;
import com.df.persistencia.Datos.dbPersonas;
import com.df.persistencia.Model.Carro;
import com.df.persistencia.Model.Persona;
import com.df.persistencia.R;
import com.df.persistencia.Views.Activities.Adapters.CarroAdapter;
import com.df.persistencia.Views.Activities.Adapters.PersonaAdaptador;

import java.util.ArrayList;

public class Carros extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private Button btnAddNewCar;
    private ListView listaCarro;
    dbCarros dbc;
    ArrayList<Carro> carros;
    CarroAdapter carAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros);
        btnAddNewCar = findViewById(R.id.addNewCar);
        btnAddNewCar.setOnClickListener(this);

        listaCarro = findViewById(R.id.listViewCar);
        listaCarro.setOnItemClickListener(this);
        updateElements();
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
        carros =dbc.obtenerCarros();//en una sola consulta se guarda la infor para usarla en otros métodos
        carAdapter = new CarroAdapter(this,carros);
        listaCarro.setAdapter(carAdapter);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.addNewCar:
                intent = new Intent(Carros.this, CrearCarro.class);
                startActivity(intent);
                break;
        }
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Ha seleccionado el carro:  "+
                carros.get(i).getName() + "propietario"+carros.get(i).getDocumento(), Toast.LENGTH_SHORT).show();
    }
}