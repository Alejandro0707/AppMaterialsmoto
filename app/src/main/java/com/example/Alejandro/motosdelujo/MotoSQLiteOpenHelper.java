package com.example.Alejandro.motosdelujo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alejandro on 04/06/2017.
 */

public class MotoSQLiteOpenHelper extends SQLiteOpenHelper{
    private String sql="CREATE TABLE Apartamentos(foto text,nomenclatura text,piso text,metros text,precio text,balcon text,sombra text)";

    public MotoSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Apartamentos");
        db.execSQL(sql);
    }
}
