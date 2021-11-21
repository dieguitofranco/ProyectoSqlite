package com.df.persistencia.Views.Activities.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.df.persistencia.Model.Vendedor;
import com.df.persistencia.R;

import java.util.ArrayList;

public class VendedorAdapter extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Vendedor> vendedores;

    public VendedorAdapter(Activity activity, ArrayList<Vendedor> vendedores) {
        this.activity = activity;
        this.vendedores = vendedores;
    }

    @Override
    public int getCount() {
        return vendedores.size();
    }

    @Override
    public Object getItem(int i) {
        return vendedores.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = view;
        if (view == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_vendedor, null);
        }
        Vendedor vendedor = vendedores.get(i);
        TextView textNamePerson = v.findViewById(R.id.textNameVendedor);
        TextView textDocument = v.findViewById(R.id.textDocumentoVendedor);
        TextView textOficina = v.findViewById(R.id.textOficina);
        TextView textPhone = v.findViewById(R.id.textTelefonoVendedor);

        textDocument.setText(vendedor.getDocumento());
        textNamePerson.setText(vendedor.getNombre());
        textOficina.setText(vendedor.getOficina());
        textPhone.setText(vendedor.getTelefono());
        return v;
    }
}
