package com.df.persistencia.Views.Activities.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.df.persistencia.Model.Carro;
import com.df.persistencia.R;

import java.util.ArrayList;

public class CarroAdaptador extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Carro> carros;

    public CarroAdaptador(Activity activity, ArrayList<Carro> carros) {
        this.activity = activity;
        this.carros = carros;
    }



    @Override
    public int getCount()  {
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

        TextView textNameC = vc.findViewById(R.id.textNameCar);
        TextView textValueC = vc.findViewById(R.id.textvalueCar);
        TextView textModeloC = vc.findViewById(R.id.textModelCar);
        TextView textTipoC = vc.findViewById(R.id.textTypeCar);
        TextView textColorC = vc.findViewById(R.id.textColorCar);
        TextView textPlacaC = vc.findViewById(R.id.textPlaca);


        textNameC.setText(car.getName());
        textValueC.setText(car.getValue());
        textModeloC.setText(String.valueOf(car.getModelo()));
        textTipoC.setText(car.getTipo());
        textColorC.setText(car.getColor());
        textPlacaC.setText(car.getPlaca());



        return vc;
    }
}
