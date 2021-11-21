package com.df.persistencia.Views.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.df.persistencia.Datos.BaseDatosCarros;
import com.df.persistencia.Datos.dbPersonas;
import com.df.persistencia.Datos.dbVendedores;
import com.df.persistencia.Model.Persona;
import com.df.persistencia.Model.Vendedor;
import com.df.persistencia.R;

public class formulario_vendedor extends AppCompatActivity implements View.OnClickListener {

    TextView textDocumentSeller ;
    TextView textNameSeller;
    TextView textEdadSeller ;
    TextView textEmailSeller ;
    TextView textPhoneSeller ;
    TextView textUrlSeller ;
    TextView textIdCarSeller ;
    Button btnAgregarVen ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_vendedor);
        textDocumentSeller = findViewById(R.id.textSellerDocument);
        textNameSeller = findViewById(R.id.textSellerName);
        textEdadSeller = findViewById(R.id.textSellerEdad);
        textEmailSeller = findViewById(R.id.textSellerEmail);
        textPhoneSeller = findViewById(R.id.textSellerPhone);
        textUrlSeller = findViewById(R.id.textSellerUrl);
        textIdCarSeller = findViewById(R.id.textSellerIdCar);
        btnAgregarVen = findViewById(R.id.btnAgregarSeller);

        btnAgregarVen.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnAgregarSeller){
            Vendedor v = new Vendedor();
            v.setDocumento(textDocumentSeller.getText().toString());
            v.setName(textNameSeller.getText().toString());
            v.setEdad(Integer.parseInt(textEdadSeller.getText().toString()));
            v.setEmail(textEmailSeller.getText().toString());
            v.setTelefono(textPhoneSeller.getText().toString());
            v.setUrl(textUrlSeller.getText().toString());
            v.setIdCar(textIdCarSeller.getText().toString());

            BaseDatosCarros dbHelper = new BaseDatosCarros(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbVendedores dbv = new dbVendedores(db);
            dbv.insertVendedor(v);
            finish();
        }
    }
}