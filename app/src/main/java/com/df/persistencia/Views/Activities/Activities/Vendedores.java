package com.df.persistencia.Views.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.df.persistencia.Datos.BaseDatosCarros;
import com.df.persistencia.Datos.dbPersonas;
import com.df.persistencia.Model.Vendedor;
import com.df.persistencia.R;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.df.persistencia.Datos.dbVendedores;
import com.df.persistencia.Views.Activities.Adapters.PersonaAdaptador;
import com.df.persistencia.Views.Activities.Adapters.VendedorAdapter;

import java.util.ArrayList;

public class Vendedores extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private Button btnAddNewVendedor;
    private ListView listaVendedor;
    dbVendedores dbcar;
    ArrayList<Vendedor> vendedores;
    VendedorAdapter vendedorAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendedores);

        btnAddNewVendedor = findViewById(R.id.btnCrear);
        btnAddNewVendedor.setOnClickListener(this);

        listaVendedor = findViewById(R.id.listViewVendedore);
        listaVendedor.setOnItemClickListener(this);
        updateElements();
    }
    @Override
    protected void onStart() {
        super.onStart();
        updateElements();
    }
    public void updateElements(){
        BaseDatosCarros dbHelper = new BaseDatosCarros(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbcar = new dbVendedores(db);
        vendedores =dbcar.obtenerVendedores();//en una sola consulta se guarda la infor para usarla en otros métodos
        vendedorAdapter = new VendedorAdapter(this,vendedores);
        listaVendedor.setAdapter(vendedorAdapter);
    }
    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnCrear:
                intent = new Intent(Vendedores.this, CrearVendedor.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Ha seleccionado el vendedor:  "+
                vendedores.get(i).getNombre(), Toast.LENGTH_SHORT).show();
    }
}