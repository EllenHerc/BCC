package com.example.ellen_.drink.entities
import java.io.Serializable


data class Drink (
    val idDrink : String,
    val strDrink : String,
    val strCategory : String? = null,
    val strIBA: String? = null,
    val strGlass: String? = null,
    val strInstructions : String? = null,
    val strDrinkThumb : String): Serializable