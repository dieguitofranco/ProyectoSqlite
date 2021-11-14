package com.df.persistencia.Views.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

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
        btnPersonas = findViewById(R.id.btnPersonasI);
        btnCarros = findViewById(R.id.btnCarrosI);
        btnPersonas.setOnClickListener(this);
        btnCarros.setOnClickListener(this);

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
    }

    @Override
    public void onClick(View v) {
        // if (v.getId() == R.id.btnPersonas){
        //      Intent intent = new Intent(MainActivity.this,  Personas.class);
        //    startActivity(intent);
        // }
        Intent intent;
        switch (v.getId()) {
            case R.id.btnPersonasI:
                // Toast.makeText(this,"IMC",Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this, Personas.class);
                // intent.putExtra("nombreUsuario",TxtNombre.getText().toString());
                startActivity(intent);
                break;
            case R.id.btnCarrosI:
                // Toast.makeText(this,"Conversor",Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this, Carros.class);
                //intent.putExtra("nombreUsuario", TxtNombre.getText().toString());
                startActivity(intent);
                break;
            // if (v.getId() == R.id.BtnCarros){
            //   Intent intent = new Intent(MainActivity.this,  Carros.class);
            // startActivity(intent);
            //    }
        }
    }
}