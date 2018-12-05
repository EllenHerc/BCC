package com.example.ellen_.drink

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListDrinksPresenter (val view : ListDrinksContract.View) : ListDrinksContract.Presenter {

    override fun onLoadList(){

        view.showLoading()

        val DrinksService = RetrofitInicializer().createDrinksService()

        val call = DrinksService.getFilter()

        call.enqueue(object : Callback<DrinkList> {
            override fun onFailure(call: Call<DrinkList>, t: Throwable) {
                view.hideLoading()
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }

            override fun onResponse(call: Call<DrinkList>, response: Response<DrinkList>) {
                view.hideLoading()
                if(response.body() != null){
                    view.showList(response.body()!!.drinks)
                }else {
                    view.showMessage("Sem notícias para hoje")
                }
            }
        })

    }
}