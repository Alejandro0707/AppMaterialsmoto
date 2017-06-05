package com.example.Alejandro.motosdelujo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Alejandro on 04/06/2017.
 */

public class DatosMotos {
    public static ArrayList<Moto> traerApartamentos(Context conexto){
        ArrayList<Moto> motos =new ArrayList<>();

        SQLiteDatabase db;
        String sql,foto,nomenclatura,piso,metros,precio,balcon,sombra;
        Moto a;

        MotoSQLiteOpenHelper aux=new MotoSQLiteOpenHelper(conexto,"DBApartamentos",null,1);
        db=aux.getReadableDatabase();

        sql ="select * from Apartamentos";
        Cursor c = db.rawQuery(sql,null);

        if (c.moveToFirst()){
            do {
                foto=c.getString(0);
                nomenclatura=c.getString(1);
                piso=c.getString(2);
                metros=c.getString(3);
                precio=c.getString(4);
                balcon=c.getString(5);
                sombra=c.getString(6);
                a=new Moto(foto,nomenclatura,piso,metros,precio,balcon,sombra);
                motos.add(a);

            }while (c.moveToNext());
        }

        db.close();
        return motos;
    }
}
