package com.lista.persistencia.Views.Activities.Carros;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lista.persistencia.Datos.BaseDatosCarros;
import com.lista.persistencia.Datos.dbCarros;
import com.lista.persistencia.Datos.dbPersonas;
import com.lista.persistencia.Model.Carro;
import com.lista.persistencia.Model.Persona;
import com.lista.persistencia.R;

public class FormularioCarros extends AppCompatActivity implements View.OnClickListener {
    TextView txtID;
    TextView txtName;
    TextView txtValue;
    TextView txtPlaca;
    TextView txtModelo;
    TextView txtColor;
    TextView txtTipo;
    TextView txtURL;
    TextView txtDOCUMENTO;
    Button btnListado;
    Button btnAgregado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_carros);
        txtID = findViewById(R.id.txtID);
        txtName = findViewById(R.id.txtName);
        txtValue = findViewById(R.id.txtValue);
        txtPlaca = findViewById(R.id.txtPlaca);
        txtModelo = findViewById(R.id.txtModelo);
        txtColor = findViewById(R.id.txtColor);
        txtTipo = findViewById(R.id.txtTipo);
        txtURL = findViewById(R.id.txtURL);
        txtDOCUMENTO = findViewById(R.id.txtDOCUMENTO);
        btnListado = findViewById(R.id.btnListado);
        btnAgregado = findViewById(R.id.btnAgregado);
        btnListado.setOnClickListener(this);
        btnAgregado.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregado){
            Carro c = new Carro();
            c.setId(txtID.getText().toString());
            c.setName(txtName.getText().toString());
            c.setValue(txtValue.getText().toString());
            c.setPlaca(txtPlaca.getText().toString());
            c.setModelo(Integer.parseInt(txtModelo.getText().toString()));
            c.setColor(txtColor.getText().toString());
            c.setTipo(txtTipo.getText().toString());
            c.setUrl(txtURL.getText().toString());
            c.setDocumento(txtDOCUMENTO.getText().toString());
            BaseDatosCarros dbHelper = new BaseDatosCarros(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbCarros dbp = new dbCarros(db);
            dbp.insertCar(c);
            finish();

        }
    }
}