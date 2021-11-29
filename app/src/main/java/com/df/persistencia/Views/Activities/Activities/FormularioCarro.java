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

public class FormularioCarro extends AppCompatActivity implements View.OnClickListener {

    TextView txtId;
    TextView txtNameCar;
    TextView txtValue;
    TextView txtPlaca;
    TextView txtModel;
    TextView txtColor;
    TextView txtType;
    TextView txtDocument2;
    TextView txtUrl;
    Button btnAddCar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_carro);
        txtId = findViewById(R.id.txtId);
        txtNameCar = findViewById(R.id.txtNameCar);
        txtValue = findViewById(R.id.txtValue);
        txtPlaca = findViewById(R.id.txtPlaca);
        txtModel = findViewById(R.id.txtModel);
        txtColor = findViewById(R.id.txtColor);
        txtType = findViewById(R.id.txtType);
        txtDocument2 = findViewById(R.id.txtDocument2);
        txtUrl = findViewById(R.id.txtUrl);

        btnAddCar = findViewById(R.id.btnAddCar);
        btnAddCar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAddCar) {
            Carro c = new Carro();
            c.setId(txtId.getText().toString());
            c.setName(txtNameCar.getText().toString());
            c.setValue(txtValue.getText().toString());
            c.setPlaca(txtPlaca.getText().toString());
            c.setModelo(Integer.parseInt(txtModel.getText().toString()));
            c.setColor(txtColor.getText().toString());
            c.setTipo(txtType.getText().toString());
            c.setDocumento(txtDocument2.getText().toString());
            c.setUrl(txtUrl.getText().toString());

            BaseDatosCarros dbHelper = new BaseDatosCarros(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbCarros dbc = new dbCarros(db);
            dbc.insertCar(c);
            finish();
        }
    }
}