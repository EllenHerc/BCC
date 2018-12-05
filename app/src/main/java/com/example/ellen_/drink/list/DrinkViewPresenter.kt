package com.example.ellen_.drink.list

import com.example.ellen_.drink.entities.Drink
import com.example.ellen_.drink.network.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DrinkViewPresenter(val view : DrinkViewContract.View) : DrinkViewContract.Presenter {
    override fun onLoadDrink() {
        view.showLoading()

        val DrinksService = RetrofitInicializer().createDrinksService()
        val call = DrinksService.getId(view.getIdDrink())
        call.enqueue(object : Callback<Drink> {
            override fun onFailure(call: Call<Drink>, t: Throwable) {
                view.hideLoading()
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }

            override fun onResponse(call: Call<Drink>, response: Response<Drink>) {
                view.hideLoading()
                if(response.body() != null){
                    view.showDrink(response.body()!!.copy())
                }else {
                    view.showMessage("Nada encontrado")
                }
            }
        })
    }
}