package com.example.ellen_.drink.list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.example.ellen_.drink.R
import com.example.ellen_.drink.entities.Drink
import kotlinx.android.synthetic.main.fragment_drink_view.*


class DrinkViewFragment : Fragment() {

    companion object {
        private val ARG_ARTICLE = "arg_article"

        fun newInstance(drink: Drink) =
            DrinkViewFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_ARTICLE, drink)
                }
            }

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
            ): View? {

        return inflater.inflate(R.layout.fragment_drink_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val drink = getDrink()

        val linearLayout = view.findViewById<LinearLayout>(R.id.linearLayout)
        val imageView = ImageView(view.context)
        linearLayout.addView(imageView)
        Glide.with(this)
            .asGif()
            .load(drink.strDrinkThumb)
            .into(imageView)

        textName.text = drink.strDrink
        textCategory.text = drink.strCategory
        textGlass.text = drink.strGlass
        textIba.text = drink.strIBA
        textInstructions.text = drink.strInstructions

    }
    fun getDrink(): Drink{
        val drink = arguments?.getSerializable(ARG_ARTICLE) as Drink?
        if(drink == null){
            throw NullPointerException("Drink can not be null")
        }

        return drink
    }


}
