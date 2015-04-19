package com.uber.android.kotlin

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.activity_main.*

public class MainActivity : Activity() {

    val fizzArray: IntArray = IntArray(10)
    var fizzIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

    fun doButton(view: View) {
        val numberOfValues : Int
        try {
            numberOfValues = editText.getText().toString().toInt()
        } catch (e: Exception) {
            numberOfValues = 0
        }

        fizzText.setText("\n")
        fizzIndex = 0
        for (i in 1..numberOfValues) {
            fizzText.append(checkValue(i) + "\n")
        }

        for (i in 0..fizzIndex - 1) {
            Log.i("MyData", "fizzArray [" + i + "] = " + fizzArray[i])
        }
    }

    fun checkValue(number: Int) : String {
        if (number % 3 == 0 && number % 5 == 0) return "FizzBuzz"
        else if (number % 3 == 0) {
            fizzArray[fizzIndex++] = number
            return "Fizz"
        }
        else if (number % 5 == 0) return "Buzz"
        else return "" + number
    }
}
