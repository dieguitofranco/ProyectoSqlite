package com.df.persistencia.Views.Activities.Activities;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.df.persistencia.Datos.BaseDatosCarros;
import com.df.persistencia.Datos.dbPersonas;
import com.df.persistencia.Model.Persona;
import com.df.persistencia.R;

public class FormularioAuto extends AppCompatActivity implements View.OnClickListener {

    TextView textNamePerson ;
    TextView textDocument ;
    TextView textEdad ;
    TextView textEmail ;
    TextView textPhone ;
    Button btnAgregar ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_usuario);
        textNamePerson = findViewById(R.id.txtName);
        textDocument = findViewById(R.id.txtDocument);
        textEdad = findViewById(R.id.txtEdad);
        textEmail = findViewById(R.id.txtEmail);
        textPhone = findViewById(R.id.txtTelefono);
        btnAgregar  = findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregar){
            Persona p = new Persona();
            p.setTelefono(textPhone.getText().toString());
            p.setDocumento(textDocument.getText().toString());
            p.setName(textNamePerson.getText().toString());
            p.setEmail(textEmail.getText().toString());
            p.setEdad(Integer.parseInt(textEdad.getText().toString()));
            BaseDatosCarros dbHelper = new BaseDatosCarros(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbPersonas dbp = new dbPersonas(db);
            dbp.insertPerson(p);
            finish();
        }
    }
}