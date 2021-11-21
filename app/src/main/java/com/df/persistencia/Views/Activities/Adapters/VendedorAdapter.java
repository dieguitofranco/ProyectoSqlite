package com.df.persistencia.Views.Activities.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.df.persistencia.Model.Vendedor;
import com.df.persistencia.R;
import com.squareup.picasso.Picasso;

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
            v = inf.inflate(R.layout.vendedor_item, null);
        }

        Vendedor vende = vendedores.get(i);
        TextView textNameS = v.findViewById(R.id.textNameSeller);
        TextView textDocumentS = v.findViewById(R.id.textDocumentSeller);
        TextView textEdadS = v.findViewById(R.id.textEdadSeller);
        TextView textEmailS = v.findViewById(R.id.textEmailSeller);
        TextView textPhoneS = v.findViewById(R.id.textPhoneSeller);
        TextView textSelCar = v.findViewById(R.id.textSellerCar);
        ImageView img = v.findViewById(R.id.imgSeller);

        textNameS.setText(vende.getName());
        textDocumentS.setText(vende.getDocumento());
        textEdadS.setText(String.valueOf(vende.getEdad()));
        textEmailS.setText(vende.getEmail());
        textPhoneS.setText(vende.getTelefono());
        textSelCar.setText(vende.getIdCar());
        Picasso.get().load(vende.getUrl()).into(img);

        return v;
    }
}
