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
import com.df.persistencia.Datos.dbCarros;
import com.df.persistencia.Datos.dbVendedores;
import com.df.persistencia.Model.Carro;
import com.df.persistencia.Model.Vendedor;
import com.df.persistencia.R;
import com.df.persistencia.Views.Activities.Adapters.CarroAdaptador;
import com.df.persistencia.Views.Activities.Adapters.VendedorAdaptador;

import java.util.ArrayList;

public class Vendedores extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private Button btnCreateSeller;
    private ListView listViewSeller;
    dbVendedores dbv;
    ArrayList<Vendedor> vendedores;
    VendedorAdaptador sellerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendedores);
        btnCreateSeller = findViewById(R.id.btnCreateSeller);
        listViewSeller = findViewById(R.id.listViewSeller);

        btnCreateSeller.setOnClickListener(this);
        listViewSeller.setOnItemClickListener(this);
        listViewSeller.setOnItemLongClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateElements();


    }

    public void updateElements() {
        BaseDatosCarros dbHelper = new BaseDatosCarros(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbv = new dbVendedores(db);
        vendedores = dbv.obtenerVendedores();
        sellerAdapter = new VendedorAdaptador(this, vendedores);
        listViewSeller.setAdapter(sellerAdapter);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnCreateSeller:
                intent = new Intent(this, FormularioVendedor.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Ha seleccionado al vendedor: ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        dbv.deleteVendedor(vendedores.get(position).getDocumentov());
        updateElements();
        return false;
    }
}