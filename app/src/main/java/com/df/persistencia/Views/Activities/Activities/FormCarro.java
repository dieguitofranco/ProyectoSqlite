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
import com.df.persistencia.R;

public class FormCarro extends AppCompatActivity implements View.OnClickListener {

    TextView textNameCarro;
    TextView textValueCarro;
    TextView textPlacaCarro;
    TextView textModelCarro;
    TextView textColorCarro;
    TextView textTypeCarro;
    TextView textDocumentPersona;
    TextView textUrlCarro;
    Button btnAgregarCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_carro);
        textNameCarro = findViewById(R.id.textNameCarro);
        textValueCarro = findViewById(R.id.textValueCarro);
        textPlacaCarro = findViewById(R.id.textPlacaCarro);
        textModelCarro = findViewById(R.id.textModelCarro);
        textColorCarro = findViewById(R.id.textColorCarro);
        textTypeCarro = findViewById(R.id.textTypeCarro);
        textUrlCarro = findViewById(R.id.textUrlCarro);
        textDocumentPersona = findViewById(R.id.textDocumentPersona);
        btnAgregarCar = findViewById(R.id.btnAgregarCar);

        btnAgregarCar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnAgregarCar){
            Carro c = new Carro();
            c.setId(textNameCarro.getText().toString());
            c.setName(textNameCarro.getText().toString());
            c.setValue(textValueCarro.getText().toString());
            c.setPlaca(textPlacaCarro.getText().toString());
            c.setModelo(Integer.parseInt(textModelCarro.getText().toString()));
            c.setColor(textColorCarro.getText().toString());
            c.setTipo(textTypeCarro.getText().toString());
            c.setDocumento(textDocumentPersona.getText().toString());
            c.setUrl(textUrlCarro.getText().toString());

            BaseDatosCarros dbHelper = new BaseDatosCarros(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbCarros dbc = new dbCarros(db);
            dbc.insertCar(c);
            finish();
        }
    }
}