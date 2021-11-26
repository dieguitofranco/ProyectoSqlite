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

    public void insertCarro(Carro carro){
        ContentValues cv = new ContentValues();
        cv.put(Estructuras.ColumnasCarro.placa, carro.getPlaca());
        cv.put(Estructuras.ColumnasCarro.color, carro.getColor());
        cv.put(Estructuras.ColumnasCarro.modelo, carro.getModelo());
        cv.put(Estructuras.ColumnasCarro.name, carro.getName());
        cv.put(Estructuras.ColumnasCarro.tipo, carro.getTipo());
        cv.put(Estructuras.ColumnasCarro.documento, carro.getDocumento());
        cv.put(Estructuras.ColumnasCarro.value, carro.getValue());
        cv.put(Estructuras.ColumnasCarro.url, "");
        db.insert(BaseDatosCarros.Tablas.Carros,null, cv);
    }

    public void deleteCarro(String id){
        db.delete(BaseDatosCarros.Tablas.Carros,Estructuras.ColumnasCarro.id + "=?",new String[] {id});
        db.close();
    }

    public int conteoCarro (){
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

    public ArrayList<Carro> obtenerCarro(){
        ArrayList<Carro> carros = new ArrayList<>();
        Cursor c = db.rawQuery("Select * from carros", null);
        if (c.getCount() > 0 ){
            c.moveToFirst();
            do{
                Carro carro = new Carro();
                carro.setDocumento(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.documento)));
                carro.setTipo(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.tipo)));
                carro.setColor(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.color)));
                carro.setName(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.name)));
                carro.setModelo(c.getInt(c.getColumnIndex(Estructuras.ColumnasCarro.modelo)));
                carro.setPlaca(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.placa)));
                carro.setValue(c.getString(c.getColumnIndex(Estructuras.ColumnasCarro.value)));
                carros.add(carro);
            }while (c.moveToNext());
        }
        c.close();
        return  carros;
    }
}
