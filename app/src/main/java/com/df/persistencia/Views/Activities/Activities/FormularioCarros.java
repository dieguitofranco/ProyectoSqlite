package com.df.persistencia.Views.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.df.persistencia.Datos.BaseDatosCarros;
import com.df.persistencia.Datos.dbCarros;
import com.df.persistencia.Model.Carro;
import com.df.persistencia.R;

public class FormularioCarros extends AppCompatActivity implements View.OnClickListener {
    TextView TxtCodigo;
    TextView txtpropietario;
    TextView txtPlaca;
    TextView txtModelo;
    TextView txtValue;
    TextView txtColor;
    TextView txtidentificacion;
    TextView txturl;
    TextView txtTipo;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_carros);
        TxtCodigo = findViewById(R.id.TxtCodigo);
        txtpropietario = findViewById(R.id.txtpropietario);
        txtValue = findViewById(R.id.txtValue);
        txtPlaca = findViewById(R.id.txtPlaca);
        txtModelo = findViewById(R.id.txtModelo);
        txtColor = findViewById(R.id.txtColor);
        txtTipo = findViewById(R.id.txtTipo);
        txtidentificacion = findViewById(R.id.txtidentificacion);
        txturl = findViewById(R.id.txtUrl);
        btnGuardar  = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnGuardar) {
            Carro c = new Carro();
            c.setId(TxtCodigo.getText().toString());
            c.setName(txtpropietario.getText().toString());
            c.setValue(txtValue.getText().toString());
            c.setPlaca(txtPlaca.getText().toString());
            c.setModelo(Integer.parseInt(txtModelo.getText().toString()));
            c.setColor(txtColor.getText().toString());
            c.setTipo(txtTipo.getText().toString());
            c.setDocumento(txtidentificacion.getText().toString());
            c.setUrl( txturl.getText().toString());

            BaseDatosCarros dbHelper = new BaseDatosCarros(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbCarros dbc = new dbCarros(db);
            dbc.insertCar(c);
            finish();
        }
    }
}