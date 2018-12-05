package com.example.ellen_.drink.list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import com.example.ellen_.drink.R
import com.example.ellen_.drink.entities.Drink
import kotlinx.android.synthetic.main.activity_list_drinks.*

class DrinkView : AppCompatActivity(), DrinkViewContract.View {

    companion object {
       public var IDDRINK: String = "13060"
    }

    var drinkID: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_drink_view)

        drinkID = intent.getSerializableExtra(IDDRINK) as String

        val presenter : DrinkViewContract.Presenter = DrinkViewPresenter(this)
        presenter.onLoadDrink()
    }

    override fun showDrink(drink: Drink) {
        val fragmentDetail = DrinkViewFragment.newInstance(drink)

        supportFragmentManager.beginTransaction()
             .replace(R.id.fmInfos, fragmentDetail)
             .commit()
    }

    override fun getIdDrink(): String {
        return drinkID
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
