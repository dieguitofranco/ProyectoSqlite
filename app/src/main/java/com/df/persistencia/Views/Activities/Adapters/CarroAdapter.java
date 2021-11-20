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

import com.df.persistencia.Model.Carro;
import com.df.persistencia.Model.Persona;
import com.df.persistencia.R;
import com.squareup.picasso.Picasso;

public class CarroAdapter extends  BaseAdapter{

    protected Activity activity;
    protected ArrayList<Carro> carros;

    public CarroAdapter(Activity activity, ArrayList<Carro> carros) {
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
            v = inf.inflate(R.layout.item_carro, null);
        }
        Carro car = carros.get(i);
        TextView textNameCar = v.findViewById(R.id.textNameCar);
        TextView textValueCar = v.findViewById(R.id.textValueCar);
        TextView textColorCar = v.findViewById(R.id.textColor);
        TextView textPlacaCar = v.findViewById(R.id.textPlaca);
        TextView textModeloCar = v.findViewById(R.id.textModelo);
        TextView textPropietario = v.findViewById(R.id.textDocumentoOwner);
        ImageView img = v.findViewById(R.id.imgPerson);

        textNameCar.setText(car.getName());
        textValueCar.setText(car.getValue());
        textColorCar.setText(car.getColor());
        textPlacaCar.setText(car.getPlaca());
        textModeloCar.setText(String.valueOf(car.getModelo()));
        textPropietario.setText(car.getDocumento());
        //Picasso.get().load("").into(img);

        return v;
    }
}
