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
    TextView textPlac ;
    TextView textModelC ;
    TextView textColorC;
    TextView textTypeC ;
    TextView textDocu ;
    TextView textUr;




    Button btnAgregarCar ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_carro);
        textId = findViewById(R.id.textID);
        textNameC = findViewById(R.id.txtNameCar);
        textValueC = findViewById(R.id.txtValue);
        textPlac = findViewById(R.id.txtPlaca);
        textModelC = findViewById(R.id.txtModel);
        textColorC = findViewById(R.id.txtColor);
        textTypeC = findViewById(R.id.txtType);
        textDocu = findViewById(R.id.textDocument2);
        textUr = findViewById(R.id.txtUrl);




        btnAgregarCar  = findViewById(R.id.btnAgregarCar);
        btnAgregarCar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregarCar) {
            Carro c = new Carro();
            c.setId(textId.getText().toString());
            c.setName(textNameC.getText().toString());
            c.setValue(textValueC.getText().toString());
            c.setPlaca(textPlac.getText().toString());
            c.setModelo(Integer.parseInt(textModelC.getText().toString()));
            c.setColor(textColorC.getText().toString());
            c.setTipo(textTypeC.getText().toString());
            c.setDocumento(textDocu.getText().toString());
            c.setUrl(textUr.getText().toString());

            BaseDatosCarros dbHelper = new BaseDatosCarros(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbCarros dbc = new dbCarros(db);
            dbc.insertCar(c);
            finish();
        }
    }
}