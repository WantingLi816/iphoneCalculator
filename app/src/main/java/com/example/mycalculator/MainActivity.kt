package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mycalculator.databinding.ActivityMainBinding

open class MainActivitySuper : AppCompatActivity() {
    protected lateinit var binding: ActivityMainBinding
    protected var operand: Double = 0.0
    protected var isDouble: Boolean = false
    protected var isInput: Boolean = false
    protected var sign: String? = null
    protected val PLUS_SIGN: String = "PLUS"
    protected val MINUS_SIGN: String = "MINUS"


    fun numInput(view: View, num: Int) {
        val priorResult = binding.result.text.toString()
//        if (!isDouble) {
//            if (priorResult == "0" || !sign.isNullOrEmpty()) {
//                binding.result.setText("$num")
//            } else {
//                binding.result.setText(priorResult + num)
//            }
//        } else {
//            if (sign.isNullOrEmpty()) {
//                binding.result.setText(priorResult + "$num")
//            } else {
//                binding.result.setText("$num")
//            }
//

        if (isInput) {
            binding.result.setText(priorResult + "$num")
        } else {
            isInput = true
            binding.result.setText("$num")
        }
    }

    fun printResult() {
        val toPrint: String
        if (!isDouble || operand.toString().endsWith("0")) {
            toPrint = operand.toInt().toString()
        } else {
            toPrint = operand.toString()
        }
        binding.result.setText(toPrint)
    }

    fun priorOperation() {
        if (sign.isNullOrEmpty()) {
            operand = binding.result.text.toString().toDouble()
        } else if (sign.equals(PLUS_SIGN)) {
            val currentInput = binding.result.text.toString().toDouble()
            operand = operand + currentInput
        } else if (sign.equals(MINUS_SIGN)){
            val currentInput = binding.result.text.toString().toDouble()
            operand -= currentInput
        }
    }
}

class MainActivity : MainActivitySuper() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun oneFun(view: View) {
        super.numInput(view,1)
    }

    fun twoFun(view: View) {
        super.numInput(view,2)
    }

    fun threeFun(view: View) {
        super.numInput(view,3)
    }

    fun fourFun(view: View) {
        super.numInput(view,4)
    }

    fun fiveFun(view: View) {
        super.numInput(view,5)
    }

    fun sixFun(view: View) {
        super.numInput(view,6)
    }

    fun sevenFun(view: View) {
        super.numInput(view,7)
    }

    fun eightFun(view: View) {
        super.numInput(view,8)
    }

    fun nineFun(view: View) {
        super.numInput(view,9)
    }

    fun zeroFun(view: View) {
        super.numInput(view,0)
    }

    fun plusFun(view: View) {
        super.priorOperation()
        super.printResult()

        sign = PLUS_SIGN
        isInput = false
    }

    fun minusFun(view: View) {
        super.priorOperation()
        super.printResult()

        sign = MINUS_SIGN
        isInput = false
    }

    fun dotFun(view: View) {
        val priorResult = binding.result.text.toString()
        isDouble = true
        isInput = true

        if (!priorResult.contains(".")) {
            binding.result.setText(priorResult + ".")
        }
    }

    fun equalFun(view: View) {
        super.priorOperation()
        super.printResult()

        sign = null
        isInput = false
    }

    fun clearFun(view: View) {
        binding.result.setText("0")
        isInput = false
    }
}