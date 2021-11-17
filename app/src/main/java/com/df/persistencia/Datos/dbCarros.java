package com.df.persistencia.Datos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.df.persistencia.Model.Carro;
import com.df.persistencia.Model.Persona;

public class dbCarros {

    SQLiteDatabase db;

    public dbCarros(SQLiteDatabase db) {
        this.db = db;
    }

    public void insertCar(Carro c){
        ContentValues cv = new ContentValues();
        cv.put(Estructuras.ColumnasCarro.id,c.getId());
        cv.put(Estructuras.ColumnasCarro.name,c.getName());
        cv.put(Estructuras.ColumnasCarro.value, c.getValue());
        cv.put(Estructuras.ColumnasCarro.placa, c.getPlaca());
        cv.put(Estructuras.ColumnasCarro.modelo, c.getModelo());
        cv.put(Estructuras.ColumnasCarro.color, c.getColor());
        cv.put(Estructuras.ColumnasCarro.tipo, c.getTipo());
        cv.put(Estructuras.ColumnasCarro.documento, c.getDocumento());
        cv.put(Estructuras.ColumnasCarro.url, c.getUrl());
        db.insert(BaseDatosCarros.Tablas.Carros,null, cv);
    }
}
