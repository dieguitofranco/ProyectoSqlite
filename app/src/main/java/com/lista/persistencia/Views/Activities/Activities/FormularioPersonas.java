package com.lista.persistencia.Views.Activities.Activities;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.lista.persistencia.Datos.BaseDatosCarros;
import com.lista.persistencia.Datos.dbPersonas;
import com.lista.persistencia.Model.Persona;
import com.lista.persistencia.R;

public class FormularioPersonas extends AppCompatActivity implements View.OnClickListener {

    TextView txtNombre ;
    TextView txtDocumento ;
    TextView txtEdad;
    TextView txtEmail ;
    TextView txtTelefono;
    Button btnAgregar;
    Button btnListar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_persona);

        txtNombre = findViewById(R.id.txtNombre);
        txtDocumento = findViewById(R.id.txtDocumento);
        txtEdad = findViewById(R.id.txtEdad);
        txtEmail = findViewById(R.id.txtEmail);
        txtTelefono = findViewById(R.id.txtTelefono);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnListar = findViewById(R.id.btnListar);
        btnAgregar.setOnClickListener(this);
        btnListar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregar){
            Persona p = new Persona("Jorge", "");
            p.setTelefono(txtTelefono.getText().toString());
            p.setName(txtNombre.getText().toString());
            p.setEdad(Integer.parseInt(txtEdad.getText().toString()));
            p.setEmail(txtEmail.getText().toString());
            p.setDocumento(txtDocumento.getText().toString());
            BaseDatosCarros dbHelper = new BaseDatosCarros(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbPersonas dbp = new dbPersonas(db);
            dbp.insertPerson(p);
            finish();

        }
    }
}