package com.df.persistencia.Views.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import com.df.persistencia.Datos.BaseDatosCarros;
import com.df.persistencia.Datos.dbVendedores;
import com.df.persistencia.Model.Vendedor;
import com.df.persistencia.R;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CrearVendedor extends AppCompatActivity implements View.OnClickListener {
    TextView textNameVendedor ;
    TextView textDocumentVendedor ;
    TextView textOficina;
    TextView textTelefono;
    Button btnAgregar ;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_vendedor);
        DisplayMetrics medidas =  new DisplayMetrics();//Describe información general sobre una pantalla
        getWindowManager().getDefaultDisplay().getMetrics(medidas);
        int ancho = medidas.widthPixels;
        int alto = medidas.heightPixels;
        getWindow().setLayout((int) (ancho*0.8), (int)(alto*0.60));

        textDocumentVendedor = findViewById(R.id.campo_documento_vendedor);
        textNameVendedor = findViewById(R.id.campo_nombre_vendedor);
        textOficina = findViewById(R.id.campo_oficina);
        textTelefono = findViewById(R.id.campo_telefono_vendedor);

        btnAgregar  = findViewById(R.id.boton_aceptar);
        btnAgregar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.boton_aceptar){
            Vendedor car = new Vendedor();
            car.setDocumento(textDocumentVendedor.getText().toString());
            car.setNombre(textNameVendedor.getText().toString());
            car.setOficina(textOficina.getText().toString());
            car.setTelefono(textTelefono.getText().toString());

            BaseDatosCarros dbHelper = new BaseDatosCarros(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbVendedores dbcar = new dbVendedores(db);
            dbcar.insertVendedor(car);
            finish();
            Intent intent = new Intent(CrearVendedor.this, Vendedores.class);
            startActivity(intent);
        }
    }
}