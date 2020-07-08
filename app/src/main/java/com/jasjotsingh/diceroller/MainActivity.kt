package com.jasjotsingh.diceroller

import android.graphics.drawable.Drawable
import android.nfc.Tag
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.simpleName
    lateinit var diceImage : ImageView
    lateinit var diceImage2: ImageView
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.imageView2)
        diceImage2 = findViewById(R.id.imageView3)

        val rollButton:Button = findViewById(R.id.button)
        diceImage2.setImageResource(getRandomDiceImage())


        rollDice()

        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
//        val dice = Dice(6)
//        val diceRoll = dice.roll()
//        //val diceImage: ImageView = findViewById(R.id.imageView2)
//        val drawableResource = when (diceRoll) {
//            1 -> R.drawable.dice_1
//            2 -> R.drawable.dice_2
//            3 -> R.drawable.dice_3
//            4 -> R.drawable.dice_4
//            5 -> R.drawable.dice_5
//            else -> R.drawable.dice_6
//        }

        diceImage.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())
        //rollDice2();
    }
    private fun rollDice2(){
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //val diceImage: ImageView = findViewById(R.id.imageView2)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage2.setImageResource(drawableResource)
    }
    private fun getRandomDiceImage() : Int {

        return (R.drawable.dice_1..R.drawable.dice_6).random()
    }
}
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}