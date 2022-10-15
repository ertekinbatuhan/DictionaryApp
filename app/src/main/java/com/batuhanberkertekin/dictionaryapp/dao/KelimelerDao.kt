package com.batuhanberkertekin.dictionaryapp.dao

import android.annotation.SuppressLint
import com.batuhanberkertekin.dictionaryapp.data.Kelimeler
import com.batuhanberkertekin.dictionaryapp.dataBase.DataBaseHelper

class KelimelerDao {


    @SuppressLint("Range")
    fun tumKelimeler(dt  : DataBaseHelper) : ArrayList<Kelimeler>{

        val kelimelerList = ArrayList<Kelimeler>()
        val db = dt.writableDatabase
        val x = db.rawQuery("SELECT * FROM kelimeler",null)

        while (x.moveToNext()){
            val word = Kelimeler(x.getInt(x.getColumnIndex("kelime_id")),
            x.getString(x.getColumnIndex("ingilizce")),x.getString(x.getColumnIndex("turkce")))

            kelimelerList.add(word)

        }
        return kelimelerList

    }

    @SuppressLint("Range")
    fun searchKelimeler(dt  : DataBaseHelper, searchWord : String) : ArrayList<Kelimeler>{

        val kelimelerList = ArrayList<Kelimeler>()
        val db = dt.writableDatabase
        val x = db.rawQuery("SELECT * FROM kelimeler WHERE ingilizce like '%%$searchWord'",null)

        while (x.moveToNext()){
            val word = Kelimeler(x.getInt(x.getColumnIndex("kelime_id")),
                x.getString(x.getColumnIndex("ingilizce")),x.getString(x.getColumnIndex("turkce")))

            kelimelerList.add(word)

        }
        return kelimelerList

    }
}