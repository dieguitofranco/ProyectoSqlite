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
import com.df.persistencia.Datos.dbPersonas;
import com.df.persistencia.Datos.dbVendedores;
import com.df.persistencia.Model.Persona;
import com.df.persistencia.Model.Vendedor;
import com.df.persistencia.R;
import com.df.persistencia.Views.Activities.Adapters.PersonaAdaptador;
import com.df.persistencia.Views.Activities.Adapters.VendedorAdaptador;

import java.util.ArrayList;

public class Vendedores extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private Button btnVendedoresAgre;
    private ListView listaVendedores;
    dbVendedores dbv;
    ArrayList<Vendedor> vendedores;
    VendedorAdaptador vendedorAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendedores);
        btnVendedoresAgre = findViewById(R.id.btnModalAgregarVend);
        listaVendedores = findViewById(R.id.lstListaVendedores);
        btnVendedoresAgre.setOnClickListener(this);
        listaVendedores.setOnItemClickListener(this);
        listaVendedores.setOnItemLongClickListener(this);
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
        vendedorAdaptador = new VendedorAdaptador(this,vendedores);
        listaVendedores.setAdapter(vendedorAdaptador);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnModalAgregarVend:
                intent = new Intent(this, FormularioVendedor.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Ha seleccionado el vendedor del carro: ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        dbv.deleteVendedor(vendedores.get(i).getId());
        updateElements();
        return false;
    }
}