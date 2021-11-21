package com.df.persistencia.Datos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.df.persistencia.Model.Carro;
import com.df.persistencia.Model.Persona;

import java.util.ArrayList;

public class dbCarros {

    SQLiteDatabase db;

    public dbCarros(SQLiteDatabase db) {
        this.db = db;
    }

    public void insertCar(Carro c){
        ContentValues cv = new ContentValues();
        cv.put(Estructuras.ColumnasCarro.name,c.getName());
        cv.put(Estructuras.ColumnasCarro.value, c.getValue());
        cv.put(Estructuras.ColumnasCarro.placa, c.getPlaca());
        cv.put(Estructuras.ColumnasCarro.modelo, c.getModelo());
        cv.put(Estructuras.ColumnasCarro.color, c.getColor());
        cv.put(Estructuras.ColumnasCarro.tipo, c.getTipo());
        cv.put(Estructuras.ColumnasCarro.url, c.getUrl());
        cv.put(Estructuras.ColumnasCarro.documento,c.getDocumento());
        cv.put(Estructuras.ColumnasCarro.vendedor,c.getDocumento_vendedor());
        db.insert(BaseDatosCarros.Tablas.Carros,null, cv);
    }

    public void deleteCar(String id_car){
        db.delete(BaseDatosCarros.Tablas.Carros,Estructuras.ColumnasCarro.id + "=?",new String[] {id_car});
        db.close();
    }


    public ArrayList<Carro> obtenerCarros(){
        ArrayList<Carro> carros = new ArrayList<>( );
        Cursor c = db.rawQuery("Select * from carros", null);
        if (c.getCount() > 0 ){
            c.moveToFirst();
            do{
                Carro car = new Carro();
                car.setName(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.name)));
                car.setValue(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.value)));
                car.setPlaca(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.placa)));
                car.setModelo(c.getInt(c.getColumnIndex(Estructuras.ColumnasCarro.modelo)));
                car.setColor(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.color)));
                car.setTipo(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.tipo)));
                car.setUrl(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.url)));
                car.setDocumento(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.documento)));
                car.setDocumento_vendedor(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.vendedor)));

                carros.add(car);
            }while (c.moveToNext());
        }
        c.close();
        return  carros;
    }

}
