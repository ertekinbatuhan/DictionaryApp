package com.batuhanberkertekin.dictionaryapp.dataBase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(mcontext : Context) : SQLiteOpenHelper(mcontext,"sozluk.sqlite",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS kelimeler(kelime_id INTEGER PRIMARY KEY AUTOINCREMENT ,ingilizce TEXT , turkce TEXT );")



    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS kelimeler")
        onCreate(db)
    }
}