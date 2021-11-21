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
    public void insertVendedor(Vendedor vendedor){
        ContentValues ven = new ContentValues();
        ven.put(Estructuras.ColumnasVendedor.documento,vendedor.getDocumento());
        ven.put(Estructuras.ColumnasVendedor.nombre,vendedor.getNombre());
        ven.put(Estructuras.ColumnasVendedor.oficina, vendedor.getOficina());
        ven.put(Estructuras.ColumnasVendedor.telefono, vendedor.getTelefono());
        db.insert(BaseDatosCarros.Tablas.Vendedores,null, ven);
    }

    public  void deleteVendedor (String document){
        db.delete(BaseDatosCarros.Tablas.Vendedores, Estructuras.ColumnasVendedor.documento + "=?", new String[] {document});
        db.close();
    }
    public ArrayList<Vendedor> obtenerVendedores(){
        ArrayList<Vendedor> vendedores = new ArrayList<>( );
        Cursor c = db.rawQuery("Select * from vendedores", null);
        if (c.getCount() > 0 ){
            c.moveToFirst();
            do{
                Vendedor vendedor = new Vendedor();
                vendedor.setDocumento(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.documento)));
                vendedor.setNombre(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.nombre)));
                vendedor.setOficina(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.oficina)));
                vendedor.setTelefono(c.getString(c.getColumnIndex(Estructuras.ColumnasVendedor.telefono)));
                vendedores.add(vendedor);
            }while (c.moveToNext());
        }
        c.close();
        return  vendedores;
    }
}
