package com.df.persistencia.Views.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.df.persistencia.Datos.BaseDatosCarros;
import com.df.persistencia.Datos.dbVendedores;
import com.df.persistencia.Model.Vendedor;
import com.df.persistencia.R;
import com.df.persistencia.Views.Activities.Adapters.VendedorAdaptador;

import java.util.ArrayList;

public class Vendedores extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {


    private Button btnCrear;
    private ListView listaVendedor;
    dbVendedores dbv;
    ArrayList<Vendedor> vendedores;
    VendedorAdaptador venAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendedor);
        btnCrear = findViewById(R.id.btnCrearVendedor);
        listaVendedor = findViewById(R.id.ListViewVendedor);
        btnCrear.setOnClickListener(this);
        listaVendedor.setOnItemClickListener(this);
        listaVendedor.setOnItemLongClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateElements();
    }

    public void updateElements(){
        BaseDatosCarros dbHelper = new BaseDatosCarros(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbv = new dbVendedores(db);
        vendedores =dbv.obtenerVendedores();
        venAdapter = new VendedorAdaptador(this,vendedores);
        listaVendedor.setAdapter(venAdapter);
    }


    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnCrearVendedor:
                intent = new Intent(this, FormularioVendedor.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Ha seleccionado el vendedor: ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        dbv.deleteVendedor(vendedores.get(position).getDocumentoV());
        updateElements();
        return false;
    }




}