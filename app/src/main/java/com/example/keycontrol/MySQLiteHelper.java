package com.example.keycontrol;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLiteHelper extends SQLiteOpenHelper {

    private final static String DB_NAME = "bd_keycontrol.sqlite";
    private final static int DB_VERSION = 1;

    public MySQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Teclado(id INTEGER, nombre TEXTO, precio DECIMAL, colorLed TEXT, img INTEGER, descripcion TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS Teclado");

        db.execSQL("CREATE TABLE Teclado(id INTEGER, nombre TEXTO, precio DECIMAL, colorLed TEXT, img NUMBER, descripcion TEXT)");


    }
}
