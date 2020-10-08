package com.example.iepirkumi

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_iepirkumu_saraksts.view.*

class Iepirkumu_adapterisdapter(
    private val listener:adapterLisener,
    private val items: MutableList<Iepirkumu_saraksts>) :
    RecyclerView.Adapter<Iepirkumu_adapterisdapter.ShoppingViewHolder>() {

    class ShoppingViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_iepirkumu_saraksts, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val item = items[position]
        val context = holder.itemView.context
        holder.itemView.shoppingName.text = item.name
        holder.itemView.shoppingQuantity.text = context.resources
            .getString(R.string.quantity_text, item.quantity, item.unit)
        holder.itemView.setOnClickListener {
            listener.removeClicked(items[position])
            Toast.makeText(context, item.name, Toast.LENGTH_SHORT).show()
        }

        holder.itemView.shoppingRemove.setOnClickListener {
            listener.removeClicked(items[position])
            items.removeAt(position)
            notifyDataSetChanged()
        }
    }
}