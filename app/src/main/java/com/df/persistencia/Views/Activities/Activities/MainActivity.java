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

   // SharedPreferences preferencias;
    //EditText txtName;
    Button btnPersonas;
    Button btnCarros;
    Button btnVends;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPersonas = findViewById(R.id.btnPersonasI);
        btnCarros = findViewById(R.id.btnCarrosI);
        btnVends = findViewById(R.id.btnVendedoresI);

        btnPersonas.setOnClickListener(this);
        btnCarros.setOnClickListener(this);
        btnVends.setOnClickListener(this);


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
    public void onClick(View view) {
       // Intent intent;
        //switch (view.getId()) {
          //  case R.id.btnPersonasI:
            //    intent = new Intent(this, Personas.class);
              //  startActivity(intent);
                //break;
            //case R.id.btnCarrosI:
              //  intent = new Intent(this, Carros.class);
                //startActivity(intent);
                //break;
            if (view.getId() == R.id.btnPersonasI){
                Intent intent = new Intent(MainActivity.this,  Personas.class);
                startActivity(intent);
            }
            else if (view.getId() == R.id.btnCarrosI){
                Intent intent = new Intent(MainActivity.this,  Carros.class);
                startActivity(intent);
            }
            else if (view.getId() == R.id.btnVendedoresI){
                Intent intent = new Intent(MainActivity.this,  Vendedores.class);
                startActivity(intent);
            }
        }

}