package com.df.persistencia.Views.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.df.persistencia.Datos.BaseDatosCarros;
import com.df.persistencia.Datos.dbCarros;
import com.df.persistencia.Datos.dbPersonas;
import com.df.persistencia.Model.Carro;
import com.df.persistencia.Model.Persona;
import com.df.persistencia.R;

public class FomularioCarro extends AppCompatActivity implements View.OnClickListener {
    TextView txtNameCarro;
    TextView txtValueCarro;
    TextView txtPlacaCarro;
    TextView txtModeloCarro;
    TextView txtColorCarro;
    TextView txtTipoCarro;
    TextView txtDocumentoCarro;
    Button btnagregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fomulario_carro);
        txtNameCarro = findViewById(R.id.txtNombreCarro);
        txtValueCarro = findViewById(R.id.txtValor);
        txtPlacaCarro = findViewById(R.id.txtPlaca);
        txtModeloCarro = findViewById(R.id.txtModelo);
        txtColorCarro = findViewById(R.id.txtColor);
        txtTipoCarro = findViewById(R.id.txtTipo);
        txtDocumentoCarro = findViewById(R.id.txtDocumento);
        btnagregar = findViewById(R.id.btnAgregarCarro);
        btnagregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnAgregar){
            Carro carro = new Carro();
            carro.setName(txtNameCarro.getText().toString());
            carro.setValue(txtValueCarro.getText().toString());
            carro.setPlaca(txtPlacaCarro.getText().toString());
            carro.setModelo(Integer.parseInt(txtModeloCarro.getText().toString()));
            carro.setColor(txtColorCarro.getText().toString());
            carro.setTipo(txtTipoCarro.getText().toString());
            carro.setDocumento(txtDocumentoCarro.getText().toString());
            carro.setUrl(null);
            BaseDatosCarros dbHelper = new BaseDatosCarros(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbCarros dbc = new dbCarros(db);
            dbc.insertCarro(carro);
            finish();
        }
    }
}