package com.df.persistencia.Views.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.df.persistencia.Datos.BaseDatosCarros;
import com.df.persistencia.Datos.dbPersonas;
import com.df.persistencia.Datos.dbVendedores;
import com.df.persistencia.Model.Persona;
import com.df.persistencia.Model.Vendedor;
import com.df.persistencia.R;

public class FormularioVendedor extends AppCompatActivity implements View.OnClickListener{

    TextView textNameVendor ;
    TextView textDocumentVendor ;
    TextView textEmailVendor ;
    TextView textPhoneVendor ;
    Button btnAgregarVendor ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_vendedor);
        textNameVendor = findViewById(R.id.txtNameVendedor);
        textDocumentVendor = findViewById(R.id.txtDocumentVendedor);
        textEmailVendor = findViewById(R.id.txtEmailVendedor);
        textPhoneVendor = findViewById(R.id.txtTelefonoVendedor);
        btnAgregarVendor  = findViewById(R.id.btnAgregarVendedor);
        btnAgregarVendor.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregarVendedor){
            Vendedor f = new Vendedor();
            f.setTelefonoV(textPhoneVendor.getText().toString());
            f.setDocumentoV(textDocumentVendor.getText().toString());
            f.setNameV(textNameVendor.getText().toString());
            f.setEmailV(textEmailVendor.getText().toString());

            BaseDatosCarros dbHelper = new BaseDatosCarros(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbVendedores dbp = new dbVendedores(db);
            dbp.insertVendor(f);
            finish();
        }
    }
}