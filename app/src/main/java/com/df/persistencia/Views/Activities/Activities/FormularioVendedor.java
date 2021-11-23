package com.df.persistencia.Views.Activities.Activities;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.df.persistencia.Datos.BaseDatosCarros;
import com.df.persistencia.Datos.dbCarros;
import com.df.persistencia.Datos.dbVendedores;
import com.df.persistencia.Model.Carro;
import com.df.persistencia.Model.Vendedor;
import com.df.persistencia.R;

public class FormularioVendedor extends AppCompatActivity implements View.OnClickListener {

    TextView textNameV ;
    TextView textDocumentV ;
    TextView texttel ;

    //TextView textUrl;
    Button btnAgregar ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_vendedor);

        textNameV = findViewById(R.id.txtNameVI);
        textDocumentV = findViewById(R.id.txtIdVI);
        texttel = findViewById(R.id.txtTelefonoVI);

        btnAgregar  = findViewById(R.id.btnAgregarCVI);
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregarCVI){
            Vendedor b = new Vendedor();

            b.setName(textNameV.getText().toString());
            b.setDocumento(textDocumentV.getText().toString());
            b.setTelefono(texttel.getText().toString());


            BaseDatosCarros dbHelper = new BaseDatosCarros(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbVendedores dbv = new dbVendedores(db);
            dbv.insertVendedor(b);
            finish();
        }
    }
}