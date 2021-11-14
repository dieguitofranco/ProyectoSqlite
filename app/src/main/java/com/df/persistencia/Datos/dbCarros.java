package com.df.persistencia.Datos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.df.persistencia.Model.Carro;

import java.util.ArrayList;

public class dbCarros {

    SQLiteDatabase db;

    public dbCarros(SQLiteDatabase db) {
        this.db = db;
    }

    public void insertCarro(Carro c){
        ContentValues cv = new ContentValues();
        cv.put(Estructuras.ColumnasCarro.name,c.getName());
        cv.put(Estructuras.ColumnasCarro.documento,c.getDocumento());
        cv.put(Estructuras.ColumnasCarro.color, c.getColor());
        cv.put(Estructuras.ColumnasCarro.id, c.getId());
        cv.put(Estructuras.ColumnasCarro.tipo, c.getTipo());
        cv.put(Estructuras.ColumnasCarro.modelo, c.getModelo());
        cv.put(Estructuras.ColumnasCarro.placa, c.getPlaca());
        cv.put(Estructuras.ColumnasCarro.value, c.getValue());
        cv.put(Estructuras.ColumnasCarro.url, c.getUrl());
       // db.insert(BaseDatosCarros.Tablas.Personas,null, cv);
    }

    public void deleteCarro(String document){
        db.delete(BaseDatosCarros.Tablas.Carros,Estructuras.ColumnasCarro.documento + "=?",new String[] {document});
        db.close();
    }

    public int conteoCarros(){
        int conteo = 0;
        Cursor c = db.rawQuery("Select count(*) as conteo from carros", null);
        if (c != null ){
            c.moveToFirst();
            do{
                conteo = c.getInt(c.getColumnIndex("conteo"));
            }while (c.moveToNext());
        }
        c.close();
        return  conteo;
    }



    public ArrayList<Carro> obtenerCarros(){
        ArrayList<Carro> carros = new ArrayList<>( );
        Cursor c = db.rawQuery("Select * from carros", null);
        if (c.getCount() > 0 ){
            c.moveToFirst();
            do{
                Carro car = new Carro();
                car.setDocumento(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.documento)));
                car.setId(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.id)));
                car.setColor(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.color)));
                car.setName(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.name)));
                car.setModelo(c.getInt(c.getColumnIndex(Estructuras.ColumnasCarro.modelo)));
                car.setPlaca(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.placa)));
                car.setTipo(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.tipo)));
                car.setValue(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.value)));
                car.setUrl(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.url)));
                carros.add(car);
            }while (c.moveToNext());
        }
        c.close();
        return  carros;
    }


}

