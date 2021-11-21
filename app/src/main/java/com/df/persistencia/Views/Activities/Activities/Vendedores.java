package com.df.persistencia.Views.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.df.persistencia.R;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.df.persistencia.Datos.dbVendedores;
import com.df.persistencia.Views.Activities.Adapters.VendedorAdapter;

import java.util.ArrayList;

public class Vendedores extends AppCompatActivity {
    private Button btnAddNewVendedor;
    private ListView listaVendedor;
    dbVendedores dbcar;
    ArrayList<Vendedores> vendedores;
    VendedorAdapter vendedorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendedores);
    }
}