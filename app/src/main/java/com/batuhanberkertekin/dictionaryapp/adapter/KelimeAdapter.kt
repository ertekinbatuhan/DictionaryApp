package com.batuhanberkertekin.dictionaryapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.batuhanberkertekin.dictionaryapp.R
import com.batuhanberkertekin.dictionaryapp.view.ResultActivity
import com.batuhanberkertekin.dictionaryapp.data.Kelimeler
import kotlinx.android.synthetic.main.recyler_view.view.*

class KelimeAdapter(private val context : Context ,private val  kelimelerList : ArrayList<Kelimeler>) : RecyclerView.Adapter<KelimeAdapter.WordObject>() {

    inner class WordObject(view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordObject {
        val design = LayoutInflater.from(context).inflate(R.layout.recyler_view,parent,false)

        return WordObject(design)


    }

    override fun onBindViewHolder(holder: WordObject, position: Int) {
     val dizi = kelimelerList.get(position)

        holder.itemView.turkishWordText.text = dizi.turkce
        holder.itemView.englishWordText.text = dizi.ingilizce


        holder.itemView.cardView.setOnClickListener {

            val intent = Intent(context, ResultActivity::class.java)
            intent.putExtra("kelimeler",dizi)
           context.startActivity(intent)



        }

    }

    override fun getItemCount(): Int {
       return kelimelerList.size
    }
}