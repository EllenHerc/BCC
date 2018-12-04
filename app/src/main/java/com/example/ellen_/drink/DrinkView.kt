package com.example.ellen_.drink

import android.support.v7.app.AppCompatActivity
import android.os.Bundle


class DrinkView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_drink_view)

    }
}
