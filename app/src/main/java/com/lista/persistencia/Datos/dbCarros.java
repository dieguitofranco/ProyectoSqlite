package com.lista.persistencia.Datos;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lista.persistencia.Model.Carro;
import com.lista.persistencia.Model.Persona;

import java.util.ArrayList;

public class dbCarros {

    SQLiteDatabase db;

    public dbCarros(SQLiteDatabase db) {
        this.db = db;

    }

    public void insertCar(Carro c){
        ContentValues cv = new ContentValues();
        cv.put(Estructuras.ColumnasCarro.id,c.getId());
        cv.put(Estructuras.ColumnasCarro.name,c.getName());
        cv.put(Estructuras.ColumnasCarro.value,c.getValue());
        cv.put(Estructuras.ColumnasCarro.placa,c.getPlaca());
        cv.put(Estructuras.ColumnasCarro.modelo,c.getModelo());
        cv.put(Estructuras.ColumnasCarro.color,c.getColor());
        cv.put(Estructuras.ColumnasCarro.tipo,c.getTipo());
        cv.put(Estructuras.ColumnasCarro.url,c.getUrl());
        db.insert(BaseDatosCarros.Tablas.Carros, null, cv);




    }

      public int conteoCarros(){
        int conteo = 0;
        Cursor c = db.rawQuery( "Select count(*) as conteo from carros", null);

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
    public ArrayList<Carro> obtenerCarros(){
        ArrayList<Carro> carros = new ArrayList<>();
        Cursor c = db.rawQuery( "Select * from carros", null);
        if (c.getCount()> 0){
            c.moveToFirst();
            do{
                Carro car = new Carro();
                car.setDocumento(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.documento)));
                car.setName(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.name)));
                car.setId(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.id)));
                car.setValue(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.value)));
                car.setPlaca(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.placa)));
                car.setModelo(Integer.parseInt(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.modelo))));
                car.setColor(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.color)));
                car.setTipo(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.tipo)));
                car.setUrl(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.url)));
                carros.add(car);

            }while (c.moveToNext());
        }
        c.close();
        return carros;
    }

    public ArrayList<Persona> insertCar() {
    return insertCar();
    }
}
