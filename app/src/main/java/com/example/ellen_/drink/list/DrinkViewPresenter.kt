package com.example.ellen_.drink.list

import com.example.ellen_.drink.entities.Drink
import com.example.ellen_.drink.entities.DrinkList
import com.example.ellen_.drink.network.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DrinkViewPresenter(val view : DrinkViewContract.View) : DrinkViewContract.Presenter {
    override fun onLoadDrink() {
        view.showLoading()

        val DrinksService = RetrofitInicializer().createDrinksService()
        val call = DrinksService.getId(view.getIdDrink())
        call.enqueue(object : Callback<DrinkList> {
            override fun onFailure(call: Call<DrinkList>, t: Throwable) {
                view.hideLoading()
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }
            override fun onResponse(call: Call<DrinkList>, response: Response<DrinkList>) {
                view.hideLoading()
                if(response.body() != null){
                    view.showDrink(response.body()!!.drinks[0])
                }else {
                    view.showMessage("Nada encontrado")
                }
            }
        })
    }
}