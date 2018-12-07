package com.example.ellen_.drink.list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.ellen_.drink.R
import com.example.ellen_.drink.entities.Drink
import kotlinx.android.synthetic.main.activity_drink_view.*

class DrinkView : AppCompatActivity(), DrinkViewContract.View {

    companion object {
       public const val IDDRINK: String = "idDrink"
    }

    var drinkID: String = "13060"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_drink_view)

        drinkID = getIntent().getStringExtra(IDDRINK)

        btnVoltar.setOnClickListener {
            this.finish()
        }
        val presenter : DrinkViewContract.Presenter = DrinkViewPresenter(this)
        presenter.onLoadDrink()
    }

    override fun showDrink(drink: Drink) {
        val linearLayout = this.findViewById<LinearLayout>(R.id.linearLayout)
        val imageView = ImageView(this)
        Glide.with(this).load(drink.strDrinkThumb).into(imageView)
        linearLayout.addView(imageView)

        textName.text = drink.strDrink
        textCategory.text = drink.strCategory
        textGlass.text = drink.strGlass
        textIba.text = drink.strIBA
        textInstructions.text = drink.strInstructions


    }

    override fun getIdDrink(): String {
        return drinkID
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
    override fun showLoading() {
        pbLoad.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoading() {
        pbLoad.visibility = ProgressBar.INVISIBLE
    }
}
