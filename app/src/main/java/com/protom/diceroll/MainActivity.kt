package com.protom.diceroll

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.lang.Math.random

class MainActivity : AppCompatActivity() {

    private val dice: Dice = Dice(6)
    private var alert: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).post {
            alert = AlertDialog.Builder(this)
                    .setTitle(R.string.win_title_alert)
                    .setIcon(R.drawable.ic_baseline_wine_bar_24)
                    .setMessage(R.string.win_message_alert)
                    .setCancelable(true)
                    .setPositiveButton(R.string.done) { dialog, which ->
                        dialog.cancel()
                    }
                    .create()
            Log.e("Class", "Alert create")
        }
    }

    fun roolDice(view: View) {
//        Toast.makeText(view.context, "Throw one dice return ${diceOne.random()}", Toast.LENGTH_LONG).show()
        Toast.makeText(view.context, "Throw one dice return ${dice.roll()}", Toast.LENGTH_SHORT).show()
    }

    fun rollTwice(view: View) {
        Toast.makeText(view.context, "Throw two dice return ${dice.roll() + dice.roll()}", Toast.LENGTH_SHORT).show()
    }

    fun lucky(view: View) {
        when (dice.roll() + dice.roll() ) {
            12 -> alert?.show()
            10,11 -> Toast.makeText(view.context, "Almost close, try again", Toast.LENGTH_SHORT).show()
            8,9 -> Toast.makeText(view.context, "You're close to lucky, try again", Toast.LENGTH_SHORT).show()
            else -> Toast.makeText(view.context, "Unlucky throw, try again", Toast.LENGTH_SHORT).show()
        }
        /*else {
            alert?.show()
        }*/
    }
}