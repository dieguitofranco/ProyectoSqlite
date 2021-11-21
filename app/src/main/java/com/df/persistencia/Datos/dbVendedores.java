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

    public void insertVendor(Vendedor v){
        ContentValues c = new ContentValues();
        c.put(Estructuras.ColumnasVendedor.name,v.getNameV());
        c.put(Estructuras.ColumnasVendedor.documento,v.getDocumentoV());
        c.put(Estructuras.ColumnasVendedor.email, v.getEmailV());
        c.put(Estructuras.ColumnasVendedor.telefono, v.getTelefonoV());
        db.insert(BaseDatosCarros.Tablas.Vendedores,null, c);
    }

    public void deleteVendedor(String documento){
        db.delete(BaseDatosCarros.Tablas.Vendedores,Estructuras.ColumnasVendedor.documento + "=?",new String[] {documento});
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
                ven.setNameV(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.name)));
                ven.setDocumentoV(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.documento)));
                ven.setEmailV(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.email)));
                ven.setTelefonoV(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.telefono)));
                vendedores.add(ven);
            }while (c.moveToNext());
        }
        c.close();
        return  vendedores;
    }
}
