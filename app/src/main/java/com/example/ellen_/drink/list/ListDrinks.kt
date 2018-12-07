package com.example.ellen_.drink.list

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import android.widget.Toast
import com.example.ellen_.drink.R
import com.example.ellen_.drink.entities.Drink
import kotlinx.android.synthetic.main.activity_list_drinks.*
import kotlinx.android.synthetic.main.fragment_drink_list.*


class ListDrinks : AppCompatActivity(), ListDrinksContract.View, DrinksListFragment.OnFragmentInteractionListener {

    var random : Boolean = false

    var lista : List<Drink>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_list_drinks)

        val strings = arrayOf("Name", "Random")
        sp_classificar.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, strings)

        sp_classificar.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(strings[position].equals("Random")){
                    random = true
                    showList(lista as List<Drink>)
                }
                else{
                    random = false
                }
                Toast.makeText(this@ListDrinks, strings[position],Toast.LENGTH_SHORT).show()
            }
        }
        val presenter : ListDrinksContract.Presenter = ListDrinksPresenter(this)
        presenter.onLoadList()
    }

    override fun showList(drink: List<Drink>) {

        saveList(drink)
        if(random){
            drink.shuffled()
        }
        val fragmentDrinksList = DrinksListFragment.newInstance(drink as ArrayList<Drink>)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fmMaster, fragmentDrinksList)
            .commit()

    }

    fun saveList(drink: List<Drink>){
        lista = drink
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