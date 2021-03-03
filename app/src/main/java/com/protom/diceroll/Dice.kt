package com.protom.diceroll

class Dice (
        private val face: Int
        ) {

    fun roll(): Int {
        return (1..face).random();
    }
}