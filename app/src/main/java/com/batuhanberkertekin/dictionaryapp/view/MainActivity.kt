package com.batuhanberkertekin.dictionaryapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.batuhanberkertekin.dictionaryapp.dataBase.DataBaseHelper
import com.batuhanberkertekin.dictionaryapp.dao.KelimelerDao
import com.batuhanberkertekin.dictionaryapp.R
import com.batuhanberkertekin.dictionaryapp.adapter.KelimeAdapter
import com.batuhanberkertekin.dictionaryapp.data.Kelimeler
import com.batuhanberkertekin.dictionaryapp.dataBase.DatabaseCopyHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  , SearchView.OnQueryTextListener{

    private lateinit var adapter : KelimeAdapter
    private lateinit var myList : ArrayList<Kelimeler>
    private lateinit var dt : DataBaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataBaseCopy()



        recylerView.setHasFixedSize(true)


        toolbar.title = "Search ..."
        setSupportActionBar(toolbar)


        recylerView.layoutManager = LinearLayoutManager(this)


        dt = DataBaseHelper(this)
        myList = KelimelerDao().tumKelimeler(dt)



        adapter =  KelimeAdapter(this,myList)


        recylerView.adapter = adapter













    }

   override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu,menu)
       val item = menu?.findItem(R.id.action_search)
        val search = item?.actionView as  SearchView
        search.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        search(query!!)


        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        search(newText!!)

        return true
    }

    fun dataBaseCopy(){
        val copyHelper = DatabaseCopyHelper(applicationContext)



        try {

         copyHelper.createDataBase()
            copyHelper.openDataBase()


        }catch (e :Exception ){
            e.printStackTrace()
        }
    }

    fun search(searchWord : String ){

        myList = KelimelerDao().searchKelimeler(dt,searchWord)
        adapter =  KelimeAdapter(this,myList)
        recylerView.adapter = adapter

    }




}