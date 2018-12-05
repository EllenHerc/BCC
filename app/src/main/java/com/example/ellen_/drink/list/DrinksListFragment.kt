package com.example.ellen_.drink.list

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ellen_.drink.R
import com.example.ellen_.drink.entities.Drink
import kotlinx.android.synthetic.main.fragment_drink_list.*

class DrinksListFragment : Fragment() {
    companion object {

        private val ARG_LIST = "arg_list"

        fun newInstance(list: ArrayList<Drink>) =
            DrinksListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_LIST, list)
                }
            }
    }

    var listener: OnFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drink_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val drinks = getDrinksList()

        activity?.let{ that ->
            val adapter = AdapterRV(that, drinks)
            adapter.setOnItemClickListener {position ->
                listener?.onFragmentInteraction(drinks[position])
            }

            rvDrinks.adapter = adapter
            rvDrinks.layoutManager = LinearLayoutManager(that)

        }

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is DrinksListFragment.OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement DrinksListFragment.OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun getDrinksList(): ArrayList<Drink>{
        val drinks = arguments?.getSerializable(ARG_LIST) as ArrayList<Drink>?
        if(drinks == null){
            throw NullPointerException("Drinks list can not be null")
        }

        return drinks
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(drink: Drink)
    }

}