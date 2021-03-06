package com.example.ellen_.drink.list

import  android.content.Context
import  android.support.v7.widget.RecyclerView
import  android.view.LayoutInflater
import android.view.View
import  android.view.ViewGroup
import com.example.ellen_.drink.R
import com.example.ellen_.drink.entities.Drink
import kotlinx.android.synthetic.main.item_list.view.*

class AdapterRV (val context: Context, val drinks: List<Drink>)
    : RecyclerView.Adapter<AdapterRV.ViewHolder>() {

    var clickListener: ((index: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return drinks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, drinks[position], clickListener)
    }

    fun setOnItemClickListener(clique: ((index: Int) -> Unit)){
        this.clickListener = clique
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context, drinks: Drink, clickListener: ((index: Int) -> Unit)?) {
            itemView.drinkName.text = drinks.strDrink
            itemView.drinkId.text = drinks.idDrink.toString()

            if (clickListener != null) {
                itemView.setOnClickListener {
                    clickListener.invoke(adapterPosition)
                }
            }
        }
    }
}