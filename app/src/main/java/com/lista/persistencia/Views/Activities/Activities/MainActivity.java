package com.lista.persistencia.Views.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lista.persistencia.Datos.BaseDatosCarros;
import com.lista.persistencia.Datos.dbPersonas;
import com.lista.persistencia.Model.Persona;
import com.lista.persistencia.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences preferencias;

    TextView txtName;
    Button btnPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPersonas = findViewById(R.id.btnPersonas);
        btnPersonas.setOnClickListener(this);

        preferencias = getSharedPreferences("local", Context.MODE_PRIVATE);

        txtName = findViewById(R.id.txtName);
        String name = preferencias.getString("Name", "");
        if (!name.equalsIgnoreCase("")) {
            {
                Toast.makeText( this, "El Nombre", Toast.LENGTH_SHORT).show();
            }
        } else {
            {
                Toast.makeText( this, "El Nombre", Toast.LENGTH_SHORT).show();
            }
        }
        BaseDatosCarros dbHelper = new BaseDatosCarros(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Persona per = new Persona("Jorge", "");
        dbPersonas dbp = new dbPersonas(db);
        dbp.insertPerson(per);
        Cursor c = db.rawQuery("Select count(*) as conteo from personas", null);
        Toast.makeText(this, dbp.conteoPersonas(), Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View v){
        if (v.getId() == R.id.btnPersonas){
            Intent intent = new Intent(MainActivity.this, Persona.class);
            startActivity(intent);

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}