package com.df.persistencia.Views.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;


import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.df.persistencia.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences preferencias;
    EditText txtName;
    Button btnPersonas;
    Button btnCarros;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPersonas = findViewById(R.id.btnPersonas);
        btnPersonas.setOnClickListener(this);

//        preferencias = getSharedPreferences("local", Context.MODE_PRIVATE);
//        txtName = findViewById(R.id.txtName);
//        String name = preferencias.getString("Name","");
//        if (!name.equalsIgnoreCase("")){
//            Toast.makeText(this, "el nombre guardado es "+ name, Toast.LENGTH_LONG).show();
//        }
//        BaseDatosCarros dbHelper = new BaseDatosCarros(this);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//       // Persona per = new Persona("Diego","");
//        dbPersonas dbp = new dbPersonas(db);
//       // dbp.insertPerson(per);
//        Toast.makeText(this,"la cantidad de personas son:" + dbp.conteoPersonas(), Toast.LENGTH_SHORT).show();

        btnPersonas = findViewById(R.id.btnPersonas);
        btnCarros = findViewById(R.id.btnPersonas);
        btnPersonas.setOnClickListener(this);
        btnCarros.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        if (v.getId() == R.id.btnAceptar){
//            SharedPreferences.Editor editor = preferencias.edit();
//            editor.putString("Name", txtName.getText().toString());
//            editor.commit();
//        }
        switch (v.getId()) {
            case R.id.btnPersonas:
                Intent intent = new Intent( MainActivity.this,Personas.class);
                startActivity(intent);
                break;
            case R.id.btnCarros:
                Intent intent2 = new Intent( MainActivity.this,Carros.class);
                startActivity(intent2);
                break;
        /*if (v.getId() == R.id.btnPersonas){
            Intent intent = new Intent(MainActivity.this,  Personas.class);
            startActivity(intent);*/


        }
    }
}