package com.lista.persistencia.Views.Activities.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lista.persistencia.Model.Persona;
import com.lista.persistencia.R;

import java.util.ArrayList;

public class PersonaAdaptador extends BaseAdapter {
    protected Activity activity;
    protected ArrayList<Persona> personas;

    public PersonaAdaptador(Activity activity, ArrayList<Persona> personas) {
        this.activity = activity;
        this.personas = personas;
    }

    @Override
    public int getCount() {
        return personas.size();
    }

    @Override
    public Object getItem(int i) {
        return personas.get(i);
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
            v = inf.inflate(R.layout.formulario_persona, null);
        }
        Persona person = personas.get(i);
        TextView txtNombre = v.findViewById(R.id.txtNombre);
        TextView txtDocumento = v.findViewById(R.id.txtDocumento);
        TextView txtEdad = v.findViewById(R.id.txtEdad);
        TextView txtEmail = v.findViewById(R.id.txtEmail);
        TextView txtTelefono = v.findViewById(R.id.txtTelefono);

        txtDocumento.setText(person.getDocumento());
        txtNombre.setText(person.getName());
        txtEdad.setText(person.getEdad());
        txtEmail.setText(person.getEmail());
        txtTelefono.setText(person.getTelefono());
        return v;
    }
}
