package com.example.ellen_.drink.list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ProgressBar
import android.widget.Toast
import com.example.ellen_.drink.R
import com.example.ellen_.drink.entities.Drink
import kotlinx.android.synthetic.main.activity_list_drinks.*


class ListDrinks : AppCompatActivity(), ListDrinksContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_list_drinks)

        val presenter : ListDrinksContract.Presenter =
            ListDrinksPresenter(this)
        presenter.onLoadList()
    }

    override fun showList(drinks: List<Drink>) {

        val adapter = AdapterRV(this, drinks)
        /*adapter.setOnItemClickListener {indexDrink ->
            val visualizaDrink = Intent(this,DrinkView::class.java)
            visualizaDrink.putExtra(DrinkView.DRINK,drinks.get(indexDrink).idDrink)
            startActivity(visualizaDrink)
        }*/

        rvDrinks.adapter = adapter
        rvDrinks.layoutManager = LinearLayoutManager(this)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        pbLoading.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoading() {
        pbLoading.visibility = ProgressBar.INVISIBLE
    }

}