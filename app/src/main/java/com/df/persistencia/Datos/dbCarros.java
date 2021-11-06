package com.df.persistencia.Datos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.df.persistencia.Model.Persona;

public class dbCarros {

    SQLiteDatabase db;

    public dbCarros(SQLiteDatabase db) {
        this.db = db;
    }


}
