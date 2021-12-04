package com.df.persistencia.Views.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.df.persistencia.Datos.BaseDatosCarros;
import com.df.persistencia.Datos.dbVendedores;
import com.df.persistencia.Model.Vendedor;
import com.df.persistencia.R;

public class FormularioVendedor extends AppCompatActivity implements View.OnClickListener {

    TextView txtDocSeller;
    TextView txtNameSeller;
    TextView txtPhone;
    TextView txtAddress;
    TextView txtEmailSeller;
    Button btnAddSeller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_vendedor);
        txtDocSeller = findViewById(R.id.txtDocSeller);
        txtNameSeller = findViewById(R.id.txtNameSeller);
        txtPhone = findViewById(R.id.txtPhone);
        txtAddress = findViewById(R.id.txtAddress);
        txtEmailSeller = findViewById(R.id.txtEmailSeller);

        btnAddSeller = findViewById(R.id.btnAddSeller);
        btnAddSeller.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAddSeller){
            Vendedor ven = new Vendedor();
            ven.setDocumentov(txtDocSeller.getText().toString());
            ven.setNombrev(txtNameSeller.getText().toString());
            ven.setTelefonov(txtPhone.getText().toString());
            ven.setDireccionv(txtAddress.getText().toString());
            ven.setCorreov(txtEmailSeller.getText().toString());


            BaseDatosCarros dbHelper = new BaseDatosCarros(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbVendedores dbp = new dbVendedores(db);
            dbp.insertVendor(ven);
            finish();
        }
    }
}