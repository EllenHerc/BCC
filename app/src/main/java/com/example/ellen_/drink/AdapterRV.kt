package com.example.ellen_.drink

import  android.content.Context
import  android.support.v7.widget.RecyclerView
import  android.view.LayoutInflater
import android.view.View
import  android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_list.view.*

class AdapterRV (val context: Context, val drinks: List<Drink>)
    : RecyclerView.Adapter<AdapterRV.ViewHolder>() {

    var clickListener: ((index: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_list_drinks, parent, false)
        return ViewHolder(view)
    }

    fun getView(position: Int,convertView: View?,parent: ViewGroup?): View{
        val view = LayoutInflater.from(context).inflate(R.layout.activity_list_drinks, parent, false)
        val drinkID = view.findViewById(R.id.drinkId) as TextView
        val drinkNAME = view.findViewById(R.id.drinkName) as TextView

        drinkID.text = drinks[position].idDrink.toString()
        drinkNAME.text = drinks[position].strDrink

        return view
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