package com.df.persistencia.Views.Activities.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.df.persistencia.Model.Carro;
import com.df.persistencia.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CarrosAdaptador extends BaseAdapter {
    protected Activity activity;
    protected ArrayList<Carro> carros;

    public CarrosAdaptador(Activity activity, ArrayList<Carro> carros) {
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
        View vc = view;
        if (view == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vc = inf.inflate(R.layout.car_item, null);
        }
        Carro car = carros.get(i);

        TextView textId = vc.findViewById(R.id.textCodigo);
        TextView textNameC = vc.findViewById(R.id.textPropietario);
        TextView textValueC = vc.findViewById(R.id.txtValue);
        TextView textPlacaC = vc.findViewById(R.id.textPlaca);
        TextView textModeloC = vc.findViewById(R.id.txtModelo);
        TextView textColorC = vc.findViewById(R.id.txtColor);
        TextView textTipoC = vc.findViewById(R.id.txtTipo);
        TextView textDocu = vc.findViewById(R.id.txtidentificacion);
        TextView textUr = vc.findViewById(R.id.txtUrl);
        ImageView img = vc.findViewById(R.id.imgCar);

        textId.setText(car.getId());
        textNameC.setText(car.getName());
        textValueC.setText(car.getValue());
        textPlacaC.setText(car.getPlaca());
        textModeloC.setText(String.valueOf(car.getModelo()));
        textColorC.setText(car.getColor());
        textTipoC.setText(car.getTipo());
        textDocu.setText(car.getDocumento());
        textUr.setText(car.getUrl());
        Picasso.get().load(car.getUrl()).into(img);



        return vc;
    }
}
