package com.acme.proyecto.facturacion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aída on 18/08/2016.
 */
public class BDFactura extends SQLiteOpenHelper {

    //String sqlCreate = "CREATE TABLE Usuarios (codigo INTEGER, nombre TEXT, nif TEXT, dir TEXT, cp INTEGER)";
    String sqlCreate = "CREATE TABLE Usuarios (codigo INTEGER, nombre TEXT)";
    public BDFactura(Context contexto, String   nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Se elimina la versión anterior de la tabla
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Usuarios");

        //Se crea la nueva versión de la tabla
        sqLiteDatabase.execSQL(sqlCreate);
    }
}
