package com.example.ellen_.drink

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