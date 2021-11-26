package com.df.persistencia.Datos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.df.persistencia.Model.Persona;
import com.df.persistencia.Model.Vendedor;

import java.util.ArrayList;

public class dbVendedores {

    SQLiteDatabase db;

    public dbVendedores(SQLiteDatabase db) {
        this.db = db;
    }

    public void insertVendedor(Vendedor v){
        ContentValues cv = new ContentValues();
        cv.put(Estructuras.ColumnasVendedor.id, v.getId());
        cv.put(Estructuras.ColumnasVendedor.documento, v.getDocumento());
        cv.put(Estructuras.ColumnasVendedor.id_car, v.getId_carro());
        db.insert(BaseDatosCarros.Tablas.Vendedores,null, cv);
    }

    public void deleteVendedor(String id){
        db.delete(BaseDatosCarros.Tablas.Vendedores,Estructuras.ColumnasVendedor.id + "=?",new String[] {id});
        db.close();
    }

    public int conteo(){
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
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        Cursor c = db.rawQuery("Select * from vendedores", null);
        if (c.getCount() > 0 ){
            c.moveToFirst();
            do{
                Vendedor vend = new Vendedor();
                vend.setDocumento(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.documento)));
                vend.setId(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.id)));
                vend.setId_carro(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.id_car)));
                vendedores.add(vend);
            }while (c.moveToNext());
        }
        c.close();
        return  vendedores;
    }
}
