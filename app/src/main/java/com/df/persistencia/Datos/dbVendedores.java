package com.df.persistencia.Datos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.df.persistencia.Model.Vendedor;

import java.util.ArrayList;

public class dbVendedores {

    SQLiteDatabase db;

    public dbVendedores(SQLiteDatabase db) {
        this.db = db;
    }

    public void insertVendedor(Vendedor v){
        ContentValues cv = new ContentValues();
        cv.put(Estructuras.ColumnasVendedor.documento,v.getDocumento());
        cv.put(Estructuras.ColumnasVendedor.name,v.getName());
        cv.put(Estructuras.ColumnasVendedor.edad, v.getEdad());
        cv.put(Estructuras.ColumnasVendedor.email, v.getEmail());
        cv.put(Estructuras.ColumnasVendedor.telefono, v.getTelefono());
        cv.put(Estructuras.ColumnasVendedor.url, v.getUrl());
        cv.put(Estructuras.ColumnasVendedor.idCar, v.getIdCar());
        db.insert(BaseDatosCarros.Tablas.Vendedores,null, cv);
    }

    public void deleteVendedor(String document){
        db.delete(BaseDatosCarros.Tablas.Vendedores,Estructuras.ColumnasVendedor.documento + "=?",new String[] {document});
        db.close();
    }

    public int conteoVendedores(){
        int conteo = 0;
        Cursor c = db.rawQuery("Select count(*) as conteo from vendedores", null);
        if (c != null ){
            c.moveToFirst();
            do{
                conteo = c.getInt(c.getColumnIndex("conteo"));
            }while (c.moveToNext());
        }
        c.close();
        return  conteo;
    }

    public ArrayList<Vendedor> obtenerVendedores(){
        ArrayList<Vendedor> vendedores = new ArrayList<>( );
        Cursor c = db.rawQuery("Select * from vendedores", null);
        if (c.getCount() > 0 ){
            c.moveToFirst();
            do{
                Vendedor ven = new Vendedor();
                ven.setDocumento(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.documento)));
                ven.setName(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.name)));
                ven.setEdad(c.getInt(c.getColumnIndex(Estructuras.ColumnasVendedor.edad)));
                ven.setEmail(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.email)));
                ven.setTelefono(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.telefono)));
                ven.setUrl(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.url)));
                ven.setIdCar(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.idCar)));
                vendedores.add(ven);
            }while (c.moveToNext());
        }
        c.close();
        return  vendedores;
    }
}
