package com.example.ellen_.drink.entities
import java.io.Serializable


data class Drink (
    var idDrink : String,
    var strDrink : String,
    var strCategory : String? = null,
    var strIBA: String? = null,
    var strGlass: String? = null,
    var strInstructions : String? = null,
    var strDrinkThumb : String): Serializable