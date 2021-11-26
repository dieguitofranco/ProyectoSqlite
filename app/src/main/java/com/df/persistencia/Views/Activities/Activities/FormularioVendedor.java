package com.df.persistencia.Views.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.df.persistencia.Datos.BaseDatosCarros;
import com.df.persistencia.Datos.dbVendedores;
import com.df.persistencia.Model.Vendedor;
import com.df.persistencia.R;


public class FormularioVendedor extends AppCompatActivity implements View.OnClickListener {

    TextView textNombreVen;
    TextView textDocumentoVen ;
    TextView textTelefonoVen ;
    TextView textDireccionVen;
    TextView textCorreoVen ;
    Button btnAgregarVen ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_vendedor);
        textDocumentoVen = findViewById(R.id.txtDocumentoV);
        textNombreVen = findViewById(R.id.txtNombreV);
        textTelefonoVen = findViewById(R.id.txtTelefonoV);
        textDireccionVen = findViewById(R.id.txtDireccionV);
        textCorreoVen = findViewById(R.id.txtCorreoV);
        btnAgregarVen  = findViewById(R.id.btnAgregarVen);
        btnAgregarVen.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregarVen){
            Vendedor ven = new Vendedor();
            ven.setDocumentov(textDocumentoVen.getText().toString());
            ven.setNombrev(textNombreVen.getText().toString());
            ven.setTelefonov(textTelefonoVen.getText().toString());
            ven.setDireccionv(textDireccionVen.getText().toString());
            ven.setCorreov(textCorreoVen.getText().toString());


            BaseDatosCarros dbHelper = new BaseDatosCarros(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbVendedores dbp = new dbVendedores(db);
            dbp.insertVendor(ven);
            finish();
        }
    }
}