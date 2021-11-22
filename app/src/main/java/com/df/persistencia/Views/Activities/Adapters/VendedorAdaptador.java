package com.df.persistencia.Views.Activities.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.df.persistencia.Model.Carro;
import com.df.persistencia.Model.Vendedor;
import com.df.persistencia.R;

import java.util.ArrayList;
//import com.squareup.picasso.Picasso;

public class VendedorAdaptador extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Vendedor> vendedores;

    public VendedorAdaptador(Activity activity, ArrayList< Vendedor> vendedores) {
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
            v = inf.inflate(R.layout.car_item, null);
        }

        Vendedor vendedor = vendedores.get(i);

        TextView txtIdVendedorJ= v.findViewById(R.id.textIdVI);
        TextView textNameVenJ = v.findViewById(R.id.textNameCarI);
        TextView texttelJ = v.findViewById(R.id.textValueI);


        txtIdVendedorJ.setText(vendedor.getDocumento());
        textNameVenJ.setText(vendedor.getName());
        texttelJ.setText(vendedor.getTelefono());

       // Picasso.get().load("https://thumbs.dreamstime.com/z/icono-de-la-muestra-del-usuario-s%C3%ADmbolo-de-la-persona-avatar-humano-84519083.jpg").into(img);

        return v;
    }
}
