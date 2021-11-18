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


    public void insertCar(Carro c){
        ContentValues vc = new ContentValues();
        vc.put(Estructuras.ColumnasCarro.id,c.getId());
        vc.put(Estructuras.ColumnasCarro.name,c.getName());
        vc.put(Estructuras.ColumnasCarro.value,c.getValue());
        vc.put(Estructuras.ColumnasCarro.placa,c.getPlaca());
        vc.put(Estructuras.ColumnasCarro.modelo,c.getModelo());
        vc.put(Estructuras.ColumnasCarro.color,c.getColor());
        vc.put(Estructuras.ColumnasCarro.tipo,c.getTipo());
        vc.put(Estructuras.ColumnasCarro.documento,c.getDocumento());
        vc.put(Estructuras.ColumnasCarro.url,c.getUrl());


        db.insert(BaseDatosCarros.Tablas.Carros,null, vc);
    }
    public void deleteCarro(String id){
        db.delete(BaseDatosCarros.Tablas.Carros,Estructuras.ColumnasCarro.id + "=?",new String[] {id});
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
                car.setId(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.id)));
                car.setName(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.name)));
                car.setValue(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.value)));
                car.setPlaca(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.placa)));
                car.setModelo(c.getInt(c.getColumnIndex(Estructuras.ColumnasCarro.modelo)));
                car.setColor(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.color)));
                car.setTipo(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.tipo)));
                car.setDocumento(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.documento)));
                car.setUrl(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.url)));


                carros.add(car);
            }while (c.moveToNext());
        }
        c.close();
        return  carros;
    }

}
