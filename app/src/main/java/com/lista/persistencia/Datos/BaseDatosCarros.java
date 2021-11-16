package com.lista.persistencia.Datos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatosCarros extends SQLiteOpenHelper {

     private static final String DATA_BASE_NAME = "carros.db";
     private static final int ACTUAL_VERSION = 1;
     private final Context context;

     public BaseDatosCarros(Context context){
         super(context, DATA_BASE_NAME, null, ACTUAL_VERSION);
         this.context = context;
     }

     interface Tablas{
         String Carros = "Carros";
         String Personas = "personas";
     }

    @Override
    public void onCreate(SQLiteDatabase db) {
                db.execSQL(String.format("CREATE TABLE %s " +
                                "(%s INTEGER PRIMARY KEY ," +  // Documento
                                " %s TEXT NOT NULL," +         // Nombre
                                " %s INTEGER NOT NULL," +      // Edad
                                " %s TEXT NOT NULL," +      // Email
                                 "%s TEXT NOT NULL)"        // Telefono
                        , Tablas.Personas, Estructuras.ColumnasPersona.documento,
                        Estructuras.ColumnasPersona.name,Estructuras.ColumnasPersona.edad,
                        Estructuras.ColumnasPersona.email,Estructuras.ColumnasPersona.telefono
                ));



         db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                          "%s TEXT NOT NULL," +  //Name
                         " %s TEXT NOT NULL," +  //Value
                         " %s TEXT NOT NULL," +  //placa
                         " %s INTEGER NOT NULL," +  //modelo
                         " %s TEXT NOT NULL," +  //color
                         " %s TEXT NOT NULL," +  //tipo
                         " %s TEXT NOT NULL," +  //url
                         " %s TEXT NOT NULL," +  //Documento
                           "foreign key(%s) references %s (%s))"
                 ,Tablas.Carros, Estructuras.ColumnasCarro.id,
                 Estructuras.ColumnasCarro.name, Estructuras.ColumnasCarro.value,
                 Estructuras.ColumnasCarro.modelo,Estructuras.ColumnasCarro.placa,
                 Estructuras.ColumnasCarro.color,Estructuras.ColumnasCarro.tipo,
                 Estructuras.ColumnasCarro.url,Estructuras.ColumnasCarro.documento,
                 Estructuras.ColumnasCarro.documento,
                 Tablas.Personas,Estructuras.ColumnasPersona.documento
         ));



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
         db.execSQL ("DROP TABLE IF EXISTS " + Tablas.Carros);
         db.execSQL ("DROP TABLE IF EXISTS " + Tablas.Personas);
         onCreate(db);

    }

}
