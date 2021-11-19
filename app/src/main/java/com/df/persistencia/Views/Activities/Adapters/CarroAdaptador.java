package com.df.persistencia.Views.Activities.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.df.persistencia.Model.Carro;
import com.df.persistencia.Model.Persona;
import com.df.persistencia.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

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
            v = inf.inflate(R.layout.carro_item, null);
        }
        Carro carro = carros.get(i);
        TextView txtNameCarro = v.findViewById(R.id.txtNombreCarro);
        TextView txtValueCarro = v.findViewById(R.id.txtValor);
        TextView txtPlacaCarro = v.findViewById(R.id.txtPlaca);
        TextView txtModeloCarro = v.findViewById(R.id.txtModelo);
        TextView txtColorCarro = v.findViewById(R.id.txtColor);
        TextView txtTipoCarro = v.findViewById(R.id.txtTipo);
        TextView txtDocumentoCarro = v.findViewById(R.id.txtDocumento);
        txtNameCarro.setText(carro.getName());
        txtValueCarro.setText(carro.getValue());
        txtPlacaCarro.setText(carro.getPlaca());
        txtModeloCarro.setText(carro.getModelo());
        txtColorCarro.setText(carro.getColor());
        txtTipoCarro.setText(carro.getTipo());
        txtDocumentoCarro.setText(carro.getDocumento());
        return v;
    }
}
