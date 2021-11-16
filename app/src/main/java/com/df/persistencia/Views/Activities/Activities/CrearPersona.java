package com.df.persistencia.Views.Activities.Activities;
import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.df.persistencia.Datos.BaseDatosCarros;
import com.df.persistencia.Datos.dbPersonas;
import com.df.persistencia.Model.Persona;
import com.df.persistencia.R;

public class CrearPersona extends AppCompatActivity implements View.OnClickListener {
    TextView textNamePerson ;
    TextView textDocument ;
    TextView textEdad ;
    TextView textEmail ;
    TextView textPhone ;
    Button btnAgregar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_persona);
        DisplayMetrics medidas =  new DisplayMetrics();//Describe información general sobre una pantalla
        getWindowManager().getDefaultDisplay().getMetrics(medidas);
        int ancho = medidas.widthPixels;
        int alto = medidas.heightPixels;
        getWindow().setLayout((int) (ancho*0.8), (int)(alto*0.60));

        textNamePerson = findViewById(R.id.campo_nombre);
        textDocument = findViewById(R.id.campo_documento);
        textEdad = findViewById(R.id.campo_edad);
        textEmail = findViewById(R.id.campo_correo);
        textPhone = findViewById(R.id.campo_telefono);
        btnAgregar  = findViewById(R.id.boton_aceptar);
        btnAgregar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.boton_aceptar){
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