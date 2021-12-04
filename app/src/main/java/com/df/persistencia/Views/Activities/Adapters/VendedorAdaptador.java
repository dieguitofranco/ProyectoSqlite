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
            v = inf.inflate(R.layout.seller_item, null);
        }
        Vendedor ven = vendedores.get(i);
        TextView textViewDocSeller = v.findViewById(R.id.textViewDocSeller);
        TextView textViewNameSeller = v.findViewById(R.id.textViewNameSeller);
        TextView textViewPhone = v.findViewById(R.id.textViewPhone);
        TextView textViewAddress = v.findViewById(R.id.textViewAddress);
        TextView textViewEmailSeller = v.findViewById(R.id.textViewEmailSeller);
        ImageView imgSeller = v.findViewById(R.id.imgSeller);

        textViewDocSeller.setText(ven.getDocumentov());
        textViewNameSeller.setText(ven.getNombrev());
        textViewPhone.setText(ven.getTelefonov());
        textViewAddress.setText(ven.getDireccionv());
        textViewEmailSeller.setText(ven.getCorreov());
        Picasso.get().load("https://thumbs.dreamstime.com/z/icono-de-la-muestra-del-usuario-s%C3%ADmbolo-de-la-persona-avatar-humano-84519083.jpg").into(imgSeller);

        return v;
    }
}
