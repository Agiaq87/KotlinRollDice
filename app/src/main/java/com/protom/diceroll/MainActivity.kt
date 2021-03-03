package com.protom.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import java.lang.Math.random

class MainActivity : AppCompatActivity() {
    /*private val diceOne: IntRange = 1..6   // IntRange
    private val diceTwo: IntRange = 2..12*/

    private val dice: Dice = Dice(6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun roolDice(view: View) {
//        Toast.makeText(view.context, "Throw one dice return ${diceOne.random()}", Toast.LENGTH_LONG).show()
        Toast.makeText(view.context, "Throw one dice return ${dice.roll()}", Toast.LENGTH_LONG).show()
    }

    fun rollTwice(view: View) {
        Toast.makeText(view.context, "Throw two dice return ${dice.roll() + dice.roll()}", Toast.LENGTH_LONG).show()
    }
}