package com.example.ellen_.drink.list

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ProgressBar
import android.widget.Toast
import com.example.ellen_.drink.R
import com.example.ellen_.drink.entities.Drink
import kotlinx.android.synthetic.main.activity_list_drinks.*
import kotlinx.android.synthetic.main.fragment_drink_list.*


class ListDrinks : AppCompatActivity(), ListDrinksContract.View, DrinksListFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_list_drinks)


        val presenter : ListDrinksContract.Presenter = ListDrinksPresenter(this)
        presenter.onLoadList()

        sp_classificar.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }
    }

    override fun showList(drink: List<Drink>) {

        val fragmentDrinksList = DrinksListFragment.newInstance(drink as ArrayList<Drink>)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fmMaster, fragmentDrinksList)
            .commit()

    }

    override fun onFragmentInteraction(drink: Drink) {

        val visualizaDrink = Intent(this,DrinkView::class.java)
        visualizaDrink.putExtra(DrinkView.IDDRINK,drink.idDrink)
        startActivity(visualizaDrink)



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