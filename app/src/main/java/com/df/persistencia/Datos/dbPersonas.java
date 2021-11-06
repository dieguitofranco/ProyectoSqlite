package com.df.persistencia.Datos;

import android.app.Person;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.df.persistencia.Model.Persona;

public class dbPersonas {

    SQLiteDatabase db;

    public dbPersonas(SQLiteDatabase db) {
        this.db = db;
    }

    public void insertPerson(Persona p){
        ContentValues cv = new ContentValues();
        cv.put(Estructuras.ColumnasPersona.name,p.getName());
        db.insert(BaseDatosCarros.Tablas.Personas,null, cv);
    }

    public int conteoPersonas(){
        int conteo = 0;
        Cursor c = db.rawQuery("Select count(*) as conteo from personas", null);
        if (c != null ){
            c.moveToFirst();
            do{
                conteo = c.getInt(c.getColumnIndex("conteo"));
            }while (c.moveToNext());
        }
        c.close();
        return  conteo;
    }


}
