package com.lista.persistencia.Views.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.lista.persistencia.Datos.BaseDatosCarros;
import com.lista.persistencia.Datos.dbPersonas;
import com.lista.persistencia.R;
import com.lista.persistencia.Views.Activities.Adapters.PersonaAdaptador;

public class Personas extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private Button btnCrear;
    private ListView listaPersona;




    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas);
        btnCrear = findViewById(R.id.btnCrear);
        listaPersona = findViewById(R.id.lstViewPerson);

        btnCrear.setOnClickListener(this);
        listaPersona.setOnClickListener(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        BaseDatosCarros dbHelper = new BaseDatosCarros(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbPersonas dbp = new dbPersonas(db);
        PersonaAdaptador perAdapter = new PersonaAdaptador(this, dbp.obtenerPersonas());
        listaPersona.setAdapter(perAdapter);
    }

    @Override
    public void onClick(View view){

        switch (view.getId()) {
            case R.id.btnCrear:
                Intent intent = new Intent(this, FormularioPersonas.class);
                 startActivity(intent);
                break;
        }
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Toast.makeText(this, "Ha Seleccionado la Persona", Toast.LENGTH_SHORT).show();
    }
}