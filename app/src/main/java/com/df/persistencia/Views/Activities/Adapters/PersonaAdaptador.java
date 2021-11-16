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

import com.df.persistencia.Model.Persona;
import com.df.persistencia.R;
import com.squareup.picasso.Picasso;

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
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = view;
        if (view == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_persona, null);
        }
        Persona person = personas.get(i);
        TextView textNamePerson = v.findViewById(R.id.textNamePerson);
        TextView textDocument = v.findViewById(R.id.textDocument);
        TextView textEdad = v.findViewById(R.id.textEdad);
        TextView textEmail = v.findViewById(R.id.textEmail);
        TextView textPhone = v.findViewById(R.id.textPhone);
        ImageView img = v.findViewById(R.id.imgPerson);

        textNamePerson.setText(person.getName());
        textDocument.setText(person.getDocumento());
        textEdad.setText(String.valueOf(person.getEdad()));
        textEmail.setText(person.getEmail());
        textPhone.setText(person.getTelefono());
        Picasso.get().load("https://thumbs.dreamstime.com/z/icono-de-la-muestra-del-usuario-s%C3%ADmbolo-de-la-persona-avatar-humano-84519083.jpg").into(img);

        return v;
    }
}
