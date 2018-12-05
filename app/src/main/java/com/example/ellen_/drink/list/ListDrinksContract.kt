package com.example.ellen_.drink.list

import com.example.ellen_.drink.entities.Drink

interface ListDrinksContract {

    interface View{
        fun showMessage(msg: String)
        fun showList(drink: List<Drink>)
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun onLoadList()
    }
}