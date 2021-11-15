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
    public Object getItem(int a) {
        return personas.get(a);
    }

    @Override
    public long getItemId(int a) {
        return a;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = view;
        if (view == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.person_item, null);
        }
        Persona person = personas.get(i);
        TextView textNamePerson = v.findViewById(R.id.textNamePer);
        TextView textDocumento = v.findViewById(R.id.textDocumentPer);
        TextView textEdad = v.findViewById(R.id.textEdadPer);
        TextView textEmail = v.findViewById(R.id.textEmailPer);
        TextView textTel = v.findViewById(R.id.textTelper);
        ImageView img = v.findViewById(R.id.imgPerson);

        textNamePerson.setText(person.getName());
        textDocumento.setText(person.getDocumento());
        textEdad.setText(String.valueOf(person.getEdad()));
        textEmail.setText(person.getEmail());
        textTel.setText(person.getTelefono());
        Picasso.get().load("https://thumbs.dreamstime.com/z/icono-de-la-muestra-del-usuario-s%C3%ADmbolo-de-la-persona-avatar-humano-84519083.jpg").into(img);

        return v;
    }
}
