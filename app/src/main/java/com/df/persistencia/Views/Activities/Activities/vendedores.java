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
import com.df.persistencia.R;
import com.df.persistencia.Model.Vendedor;
import com.df.persistencia.Views.Activities.Adapters.VendedorAdapter;

import java.util.ArrayList;

public class vendedores extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private Button btnCrearSeller;
    private ListView listViewSeller;
    dbVendedores dbv;
    ArrayList<Vendedor> vendedores;
    VendedorAdapter venAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendedores);
        btnCrearSeller = findViewById(R.id.btnCrearSeller);
        listViewSeller = findViewById(R.id.listViewSeller);

        btnCrearSeller.setOnClickListener(this);
        listViewSeller.setOnItemClickListener(this);
        listViewSeller.setOnItemLongClickListener(this);
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
        vendedores = dbv.obtenerVendedores();
        venAdapter = new VendedorAdapter(this,vendedores);
        listViewSeller.setAdapter(venAdapter);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnCrearSeller:
                intent = new Intent(this, formulario_vendedor.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Vendedor vendedorSelect = vendedores.get(i);
        Toast.makeText(this, "Ha seleccionado el vendedor: " + vendedorSelect.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        Vendedor vendedorSelect = vendedores.get(i);
        Toast.makeText(this, "Se ha eliminado la persona: " + vendedorSelect.getName(), Toast.LENGTH_SHORT).show();
        dbv.deleteVendedor(vendedores.get(i).getDocumento());
        updateElements();
        return false;
    }
}