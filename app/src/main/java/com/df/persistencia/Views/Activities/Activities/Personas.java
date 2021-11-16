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
import com.df.persistencia.Datos.dbPersonas;
import com.df.persistencia.Model.Persona;
import com.df.persistencia.R;
import com.df.persistencia.Views.Activities.Adapters.PersonaAdaptador;

import java.util.ArrayList;

public class Personas extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private Button btnCrear;
    private ListView listaPersona;
    dbPersonas dbp;
    ArrayList<Persona> personas;
    PersonaAdaptador perAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas);
        btnCrear = findViewById(R.id.btnCrear);
        btnCrear.setOnClickListener(this);

        listaPersona = findViewById(R.id.listViewPerson);
        listaPersona.setOnItemClickListener(this);
        listaPersona.setOnItemLongClickListener(this);
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
        dbp = new dbPersonas(db);
        personas =dbp.obtenerPersonas();//en una sola consulta se guarda la infor para usarla en otros métodos
        perAdapter = new PersonaAdaptador(this,personas);
        listaPersona.setAdapter(perAdapter);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnCrear:
                intent = new Intent(Personas.this, CrearPersona.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Ha seleccionado la persona:  "+
                personas.get(i).getName(), Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        dbp.deletePersona(personas.get(position).getDocumento());
        updateElements();
        return false;
    }
}