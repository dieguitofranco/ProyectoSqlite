package com.df.persistencia.Views.Activities.Activities;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.df.persistencia.Datos.BaseDatosCarros;
import com.df.persistencia.Datos.dbCarros;
import com.df.persistencia.Model.Carro;
import com.df.persistencia.R;

public class FormularioVendedor extends AppCompatActivity implements View.OnClickListener {

    TextView textNameCar ;
    TextView textDocumentC ;
    TextView textColor ;
    TextView textId ;
    TextView textTipo ;
    TextView textModelo;
    TextView textPlaca;
    TextView textValue;
    //TextView textUrl;
    Button btnAgregar ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_auto);

        textNameCar = findViewById(R.id.txtNameI);
        textDocumentC = findViewById(R.id.txtDocument);
        textColor = findViewById(R.id.textColorI);
        textId = findViewById(R.id.txtIdI);
        textTipo = findViewById(R.id.textTipoI);
        textModelo = findViewById(R.id.textModeloI);
        textPlaca = findViewById(R.id.textPlacaI);
        textValue = findViewById(R.id.txtValorI);

        btnAgregar  = findViewById(R.id.btnAgregarCI);
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregarCI){
            Carro c = new Carro();

            c.setTipo(textTipo.getText().toString());
            c.setDocumento(textDocumentC.getText().toString());
            c.setName(textNameCar.getText().toString());
            c.setId(textId.getText().toString());
            c.setColor(textColor.getText().toString());
            c.setModelo(textModelo.getScrollX());
            c.setPlaca(textPlaca.getText().toString());
            c.setValue(textValue.getText().toString());
            c.setName(textNameCar.getText().toString());

            BaseDatosCarros dbHelper = new BaseDatosCarros(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbCarros dbc = new dbCarros(db);
            dbc.insertCarro(c);
            finish();
        }
    }
}