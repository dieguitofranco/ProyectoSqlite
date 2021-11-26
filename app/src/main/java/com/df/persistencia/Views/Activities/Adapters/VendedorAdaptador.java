package com.df.persistencia.Views.Activities.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.df.persistencia.Model.Vendedor;
import com.df.persistencia.R;
import com.squareup.picasso.Picasso;

public class VendedorAdaptador extends BaseAdapter{

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
            v = inf.inflate(R.layout.vendedor_item, null);
        }
       Vendedor ven = vendedores.get(i);
        TextView textDocumentoVen = v.findViewById(R.id.textDocumentoVen);
        TextView textNombreVen = v.findViewById(R.id.textNombreVen);
        TextView textTelefonoVen = v.findViewById(R.id.textTelefonoVen);
        TextView textDireccionVen = v.findViewById(R.id.textDireccionVen);
        TextView textCorreVen = v.findViewById(R.id.textCorreoVen);
        ImageView img = v.findViewById(R.id.imgVen);

        textDocumentoVen.setText(ven.getDocumentov());
        textNombreVen.setText(ven.getNombrev());
        textTelefonoVen.setText(ven.getTelefonov());
        textDireccionVen.setText(ven.getDireccionv());
        textCorreVen.setText(ven.getCorreov());
        Picasso.get().load("https://thumbs.dreamstime.com/z/icono-de-la-muestra-del-usuario-s%C3%ADmbolo-de-la-persona-avatar-humano-84519083.jpg").into(img);

        return v;
    }
}
