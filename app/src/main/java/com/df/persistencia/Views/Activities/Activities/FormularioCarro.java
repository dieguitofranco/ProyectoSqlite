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


    TextView textId;
    TextView textNameC ;
    TextView textValueC ;
    TextView textModelC ;
    TextView textTypeC ;
    TextView textPlac ;
    TextView textColorC;




    Button btnAgregarCar ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_carro);
        textNameC = findViewById(R.id.txtNameCar);
        textValueC = findViewById(R.id.txtValue);
        textModelC = findViewById(R.id.txtModel);
        textTypeC = findViewById(R.id.txtType);
        textColorC = findViewById(R.id.txtColor);
        textPlac = findViewById(R.id.txtPlaca);


        btnAgregarCar  = findViewById(R.id.btnAgregarCar);
        btnAgregarCar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregarCar) {
            Carro c = new Carro();
            c.setName(textNameC.getText().toString());
            c.setValue(textValueC.getText().toString());
            c.setModelo(Integer.parseInt(textModelC.getText().toString()));
            c.setTipo(textTypeC.getText().toString());
            c.setColor(textColorC.getText().toString());
            c.setPlaca(textPlac.getText().toString());

            BaseDatosCarros dbHelper = new BaseDatosCarros(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbCarros dbc = new dbCarros(db);
            dbc.insertCar(c);
            finish();
        }
    }
}