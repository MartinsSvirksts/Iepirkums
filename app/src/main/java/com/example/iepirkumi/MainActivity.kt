package com.example.iepirkumi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), adapterLisener {

    private val db by lazy {
        (application as app).db.Iepirkumu_saraksts()
    }

    private val items = mutableListOf<Iepirkumu_saraksts>()

    private lateinit var adapter: Iepirkumu_adapterisdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items.addAll(db.getAll())

        adapter = Iepirkumu_adapterisdapter(this,items)
        mainItems.adapter = adapter

        mainButtonAdd.setOnClickListener { appendItem() }
    }

    private fun appendItem() {
        val item = Iepirkumu_saraksts(mainEditName.text.toString(), 1, "")
        item.uid = db.insertAll(item).first()

        items.add(item)
        items.sortBy { it.name }
        mainEditName.text.clear()
        adapter.notifyDataSetChanged()

    }

    override fun removeClicked(item: Iepirkumu_saraksts) {
        println(item)
        db.delete(item)

    }

    override fun itemClicked(item: Iepirkumu_saraksts) {

    }

}

    interface adapterLisener {
        fun removeClicked(item: Iepirkumu_saraksts)

        fun itemClicked(item: Iepirkumu_saraksts)
}