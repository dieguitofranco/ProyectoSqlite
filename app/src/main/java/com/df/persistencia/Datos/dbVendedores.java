package com.df.persistencia.Datos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.df.persistencia.Model.Carro;
import com.df.persistencia.Model.Vendedor;

import java.util.ArrayList;


public class dbVendedores {

    SQLiteDatabase db;

    public dbVendedores(SQLiteDatabase db) {

        this.db = db;
    }

    public void insertVendor(Vendedor v){
        ContentValues c = new ContentValues();
        c.put(Estructuras.ColumnasVendedor.documentov,v.getDocumentov());
        c.put(Estructuras.ColumnasVendedor.nombrev,v.getNombrev());
        c.put(Estructuras.ColumnasVendedor.telefonov, v.getTelefonov());
        c.put(Estructuras.ColumnasVendedor.direccionv, v.getDireccionv());
        c.put(Estructuras.ColumnasVendedor.correov, v.getCorreov());
        db.insert(BaseDatosCarros.Tablas.Vendedores,null, c);
    }

    public void deleteVendedor(String documento){
        db.delete(BaseDatosCarros.Tablas.Vendedores,Estructuras.ColumnasVendedor.documentov + "=?",new String[] {documento});
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
                Vendedor ver = new Vendedor();
                ver.setDocumentov(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.documentov)));
                ver.setNombrev(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.nombrev)));
                ver.setTelefonov(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.telefonov)));
                ver.setDireccionv(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.direccionv)));
                ver.setCorreov(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.correov)));

                vendedores.add(ver);
            }while (c.moveToNext());
        }
        c.close();
        return  vendedores;
    }
}
