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
        cv.put(Estructuras.ColumnasPersona.name,v.getName());
        cv.put(Estructuras.ColumnasPersona.documento,v.getDocumento());
        cv.put(Estructuras.ColumnasPersona.telefono, v.getTelefono());
        db.insert(BaseDatosCarros.Tablas.Personas,null, cv);
    }

    public void deleteVendedor(String document){
        db.delete(BaseDatosCarros.Tablas.Personas,Estructuras.ColumnasPersona.documento + "=?",new String[] {document});
        db.close();
    }

    public int conteoVendedores(){
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



    public ArrayList<Vendedor> obtenerVendedores(){
        ArrayList<Vendedor> vendedores = new ArrayList<>( );
        Cursor c = db.rawQuery("Select * from vendedores", null);
        if (c.getCount() > 0 ){
            c.moveToFirst();
            do{
                Vendedor ven = new Vendedor();
                ven.setDocumento(c.getString(c.getColumnIndex(Estructuras.ColumnasPersona.documento)));
                ven.setName(c.getString(c.getColumnIndex(Estructuras.ColumnasPersona.name)));
                ven.setTelefono(c.getString(c.getColumnIndex(Estructuras.ColumnasPersona.telefono)));
                vendedores.add(ven);
            }while (c.moveToNext());
        }
        c.close();
        return  vendedores;
    }


}
