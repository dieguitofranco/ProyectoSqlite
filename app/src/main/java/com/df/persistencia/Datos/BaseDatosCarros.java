package com.df.persistencia.Datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatosCarros extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME = "carros.db";
    private static final int ACTUAL_VERSION = 2;
    private final Context context;

    public BaseDatosCarros(Context context) {
        super(context, DATA_BASE_NAME,null,ACTUAL_VERSION);
        this.context = context;
    }

    interface Tablas{
        String Carros = "carros";
        String Personas = "personas";
        String Vendedores = "vendedores";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE %s " +
                        "(%s TEXT PRIMARY KEY," + //documento
                        "%s TEXT NOT NULL," + //nombre
                        "%s INTEGER NOT NULL," + //edad
                        "%s TEXT NOT NULL," + //email
                        "%s TEXT NOT NULL)", //telefono
                Tablas.Personas,
                Estructuras.ColumnasPersona.documento,
                Estructuras.ColumnasPersona.name,
                Estructuras.ColumnasPersona.edad,
                Estructuras.ColumnasPersona.email,
                Estructuras.ColumnasPersona.telefono));


        db.execSQL(String.format("CREATE TABLE %s " +
                        "(%s INTEGER PRIMARY KEY AUTOINCREMENT," + //id
                        "%s TEXT NOT NULL, " +  //name
                        "%s TEXT NOT NULL," + //value
                        "%s TEXT NOT NULL," + //placa
                        "%s INTEGER NOT NULL," + //modelo
                        "%s TEXT NOT NULL," + //color
                        "%s TEXT NOT NULL," + //tipo
                        "%s TEXT NOT NULL," + //url
                        "%s TEXT NOT NULL," + //documento
                        "foreign key(%s) references %s (%s))" //declaracion llave foranea
                ,Tablas.Carros,
                Estructuras.ColumnasCarro.id,
                Estructuras.ColumnasCarro.name,
                Estructuras.ColumnasCarro.value,
                Estructuras.ColumnasCarro.placa,
                Estructuras.ColumnasCarro.modelo,
                Estructuras.ColumnasCarro.color,
                Estructuras.ColumnasCarro.tipo,
                Estructuras.ColumnasCarro.url,
                Estructuras.ColumnasCarro.documento,
                Estructuras.ColumnasCarro.documento,//llave foranea
                Tablas.Personas, Estructuras.ColumnasPersona.documento));

        db.execSQL(String.format("CREATE TABLE %s " +
                        "(%s TEXT PRIMARY KEY," + //documento
                        "%s TEXT NOT NULL," + //nombre
                        "%s TEXT NOT NULL)", //telefono
                Tablas.Vendedores,
                Estructuras.ColumnasPersona.documento,
                Estructuras.ColumnasPersona.name,
                Estructuras.ColumnasPersona.telefono));


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ Tablas.Carros);
        db.execSQL("DROP TABLE IF EXISTS "+ Tablas.Personas);
        db.execSQL("DROP TABLE IF EXISTS "+ Tablas.Vendedores);
        onCreate(db);
    }
}
