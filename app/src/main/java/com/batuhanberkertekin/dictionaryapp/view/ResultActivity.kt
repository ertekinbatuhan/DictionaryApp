package com.batuhanberkertekin.dictionaryapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.batuhanberkertekin.dictionaryapp.R
import com.batuhanberkertekin.dictionaryapp.data.Kelimeler
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val intent = getIntent().getSerializableExtra("kelimeler") as Kelimeler


        ingText.text = intent.ingilizce
        turkText.text = intent.turkce

    }
}