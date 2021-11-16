package com.lista.persistencia.Datos;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lista.persistencia.Model.Persona;

import java.util.ArrayList;

public class dbPersonas {

    SQLiteDatabase db;

    public dbPersonas(SQLiteDatabase db) {
        this.db = db;

    }

    public void insertPerson(Persona p){
        ContentValues cv = new ContentValues();
        cv.put(Estructuras.ColumnasPersona.name,p.getName());
        cv.put(Estructuras.ColumnasPersona.documento,p.getDocumento());
        cv.put(Estructuras.ColumnasPersona.edad,p.getEdad());
        cv.put(Estructuras.ColumnasPersona.email,p.getEmail());
        cv.put(Estructuras.ColumnasPersona.telefono,p.getTelefono());
        db.insert(BaseDatosCarros.Tablas.Personas, null, cv);




    }
    @SuppressLint("Range")
    public int conteoPersonas(){
        int conteo = 0;
        Cursor c = db.rawQuery( "Select count(*) as conteo from personas", null);

        if (c != null){
            c.moveToFirst();
            do{
                conteo = c.getInt(c.getColumnIndex("conteo"));
            }while (c.moveToNext());
        }
        c.close();
        return conteo;


    }
    @SuppressLint("Range")
    public ArrayList<Persona> obtenerPersonas(){
        ArrayList<Persona> personas = new ArrayList<>();
        Cursor c = db.rawQuery( "Select * from personas", null);
        if (c.getCount()> 0){
            c.moveToFirst();
            do{
                Persona per = new Persona("Jorge", "");
                per.setDocumento(c.getString(c.getColumnIndex(Estructuras.ColumnasPersona.documento)));
                per.setEdad(c.getInt(c.getColumnIndex(Estructuras.ColumnasPersona.edad)));
                per.setEmail(c.getString(c.getColumnIndex(Estructuras.ColumnasPersona.email)));
                per.setName(c.getString(c.getColumnIndex(Estructuras.ColumnasPersona.name)));
                per.setTelefono(c.getString(c.getColumnIndex(Estructuras.ColumnasPersona.telefono)));
                personas.add(per);

            }while (c.moveToNext());
        }
        c.close();
        return personas;
    }
}
