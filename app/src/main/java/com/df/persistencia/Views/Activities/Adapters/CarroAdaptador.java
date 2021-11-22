package com.df.persistencia.Views.Activities.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
//import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.df.persistencia.Model.Carro;
import com.df.persistencia.R;
//import com.squareup.picasso.Picasso;

public class CarroAdaptador extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Carro> carros;

    public CarroAdaptador(Activity activity, ArrayList<Carro> carros) {
        this.activity = activity;
        this.carros = carros;
    }

    @Override
    public int getCount() {
        return carros.size();
    }

    @Override
    public Object getItem(int i) {
        return carros.get(i);
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

        Carro carro = carros.get(i);

        TextView textIdJ= v.findViewById(R.id.textIdI);
        TextView textNameCarJ = v.findViewById(R.id.textNameCarI);
        TextView textValueJ = v.findViewById(R.id.textValueI);
        TextView textPlacaJ = v.findViewById(R.id.textPlacaI);
        TextView textModeloJ = v.findViewById(R.id.textModeloI);
        //ImageView img = v.findViewById(R.id.imgPerson);
        TextView textColorJ = v.findViewById(R.id.textColorI);
        TextView textTipoJ = v.findViewById(R.id.textTipoI);
        TextView textDocumentoJ = v.findViewById(R.id.textDocumentoPI);


        textIdJ.setText(carro.getId());
        textNameCarJ.setText(carro.getName());
        textValueJ.setText(String.valueOf(carro.getValue()));
        textPlacaJ.setText(carro.getPlaca());
        textModeloJ.setText(carro.getModelo());
        textColorJ.setText(carro.getColor());
        textTipoJ.setText(carro.getTipo());
        textDocumentoJ.setText(carro.getDocumento());
       // Picasso.get().load("https://thumbs.dreamstime.com/z/icono-de-la-muestra-del-usuario-s%C3%ADmbolo-de-la-persona-avatar-humano-84519083.jpg").into(img);

        return v;
    }
}
