package com.lista.persistencia.Views.Activities.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lista.persistencia.Model.Carro;
import com.lista.persistencia.Model.Persona;
import com.lista.persistencia.R;

import java.util.ArrayList;

public class CarroAdaptador extends BaseAdapter {
    protected Activity activity;
    protected ArrayList<Carro> carros;

    public CarroAdaptador(Activity activity, ArrayList<Persona> personas) {
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
    public View getView(int i, View view, ViewGroup parent) {
        View v = view;
        if(view == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.activity_formulario_carros, null);
        }
        Carro carro = carros.get(i);
        TextView txtId = v.findViewById(R.id.txtID);
        TextView txtName = v.findViewById(R.id.txtName);
        TextView txtValue = v.findViewById(R.id.txtValue);
        TextView txtPlaca = v.findViewById(R.id.txtPlaca);
        TextView txtModelo = v.findViewById(R.id.txtModelo);
        TextView txtColor = v.findViewById(R.id.txtColor);
        TextView txtTipo = v.findViewById(R.id.txtTipo);
        TextView txtURL = v.findViewById(R.id.txtURL);
        TextView txtDOCUMENTO = v.findViewById(R.id.txtDOCUMENTO);

        txtDOCUMENTO.setText(carro.getDocumento());
        txtId.setText(carro.getId());
        txtName.setText(carro.getName());
        txtValue.setText(carro.getValue());
        txtPlaca.setText(carro.getPlaca());
        txtModelo.setText(carro.getModelo());
        txtColor.setText(carro.getColor());
        txtTipo.setText(carro.getTipo());
        txtURL.setText(carro.getUrl());
        return v;
    }
}

