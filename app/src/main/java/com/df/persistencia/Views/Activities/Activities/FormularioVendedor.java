package com.df.persistencia.Views.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.df.persistencia.Datos.BaseDatosCarros;
import com.df.persistencia.Datos.dbPersonas;
import com.df.persistencia.Datos.dbVendedores;
import com.df.persistencia.Model.Vendedor;
import com.df.persistencia.R;

public class FormularioVendedor extends AppCompatActivity implements View.OnClickListener {

    TextView txtIdDocumento;
    TextView txtIdCarro;
    Button btnAgregarVendedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_vendedor);
        txtIdDocumento = findViewById(R.id.txtDocumento);
        txtIdCarro = findViewById(R.id.txtPlacaCarroVendedor);
        btnAgregarVendedor = findViewById(R.id.btnAgregarVendedor);
        btnAgregarVendedor.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnAgregarVendedor) {
            Vendedor vendedor = new Vendedor();
            vendedor.setDocumento(txtIdDocumento.getText().toString());
            vendedor.setId_carro(txtIdCarro.getText().toString());
            BaseDatosCarros dbHelper = new BaseDatosCarros(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbVendedores dbv = new dbVendedores(db);
            dbv.insertVendedor(vendedor);
            finish();

        }

    }
}