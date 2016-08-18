package com.acme.proyecto.facturacion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aída on 18/08/2016.
 */
public class BDFactura extends SQLiteOpenHelper {
    public BDFactura(Context contexto, String   nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
