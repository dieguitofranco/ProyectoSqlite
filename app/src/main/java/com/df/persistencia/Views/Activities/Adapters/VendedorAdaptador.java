package com.df.persistencia.Views.Activities.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.df.persistencia.Model.Persona;
import com.df.persistencia.Model.Vendedor;
import com.df.persistencia.R;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class VendedorAdaptador extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Vendedor> vendedores;

    public VendedorAdaptador(Activity activity, ArrayList<Vendedor> vendedores) {
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
            v = inf.inflate(R.layout.vendor_item, null);
        }
        Vendedor vendor = vendedores.get(i);
        TextView textNameVendedor = v.findViewById(R.id.textNameVendor);
        TextView textDocumentoVendedor = v.findViewById(R.id.textDocumentVendor);
        TextView textEmailVendedor = v.findViewById(R.id.textEmailVendor);
        TextView textTelVendedor = v.findViewById(R.id.textTelefonoVendor);
        ImageView imgVendeor = v.findViewById(R.id.imageVendor);

        textNameVendedor.setText(vendor.getNameV());
        textDocumentoVendedor.setText(vendor.getDocumentoV());
        textEmailVendedor.setText(vendor.getEmailV());
        textTelVendedor.setText(vendor.getTelefonoV());
        Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiFURDs9eaP4MBNmI_xnCiUfERd8-v2POkWA&usqp=CAU").into(imgVendeor);

        return v;
    }
}
