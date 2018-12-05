package com.example.ellen_.drink.list

import com.example.ellen_.drink.entities.Drink

interface DrinkViewContract {
    interface View{
        fun showMessage(msg: String)
        fun showDrink( drink: Drink)
        fun getIdDrink():String
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun onLoadDrink()
    }
}