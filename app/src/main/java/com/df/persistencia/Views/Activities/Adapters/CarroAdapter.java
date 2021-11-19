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
import com.df.persistencia.Model.Persona;
import com.df.persistencia.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CarroAdapter extends BaseAdapter {

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
            v = inf.inflate(R.layout.car_item, null);
        }
        Carro car = carros.get(i);
        TextView textNameCar = v.findViewById(R.id.textNameCar);
        TextView textValue = v.findViewById(R.id.textValueCar);
        TextView textPlaca = v.findViewById(R.id.texPlacaCar);
        TextView textModel = v.findViewById(R.id.textModelCar);
        TextView textColor = v.findViewById(R.id.textColorCar);
        TextView textType = v.findViewById(R.id.textTypeCar);
        TextView textDocument = v.findViewById(R.id.textDocumentPerson);
        ImageView img = v.findViewById(R.id.imgCar);

        textNameCar.setText(car.getName());
        textValue.setText(String.valueOf(car.getValue()));
        textPlaca.setText(car.getPlaca());
        textModel.setText(car.getModelo());
        textColor.setText(car.getColor());
        textType.setText(car.getTipo());
        textDocument.setText(car.getDocumento());
        Picasso.get().load(car.getUrl()).into(img);

        return v;
    }
}
