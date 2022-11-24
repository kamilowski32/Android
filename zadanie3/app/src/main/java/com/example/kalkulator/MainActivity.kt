package com.example.kalkulator

import net.objecthunter.exp4j.*
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kalkulator.R.*


class MainActivity : AppCompatActivity() {
    private var operation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        findViewById<Button>(id.b0).setOnClickListener { appendString("0") }
        findViewById<Button>(id.b1).setOnClickListener { appendString("1") }
        findViewById<Button>(id.b2).setOnClickListener { appendString("2") }
        findViewById<Button>(id.b3).setOnClickListener { appendString("3") }
        findViewById<Button>(id.b4).setOnClickListener { appendString("4") }
        findViewById<Button>(id.b5).setOnClickListener { appendString("5") }
        findViewById<Button>(id.b6).setOnClickListener { appendString("6") }
        findViewById<Button>(id.b7).setOnClickListener { appendString("7") }
        findViewById<Button>(id.b8).setOnClickListener { appendString("8") }
        findViewById<Button>(id.b9).setOnClickListener { appendString("9") }
        findViewById<Button>(id.bminus).setOnClickListener {appendString("-")}
        findViewById<Button>(id.bdiv).setOnClickListener {appendString("/")}
        findViewById<Button>(id.blog).setOnClickListener {appendString("log")}
        findViewById<Button>(id.bplus).setOnClickListener {appendString("+")}
        findViewById<Button>(id.bpow).setOnClickListener {appendString("^")}
        findViewById<Button>(id.bmulti).setOnClickListener {appendString("*")}
        findViewById<Button>(id.bC).setOnClickListener {resetString()}
        findViewById<Button>(id.bper).setOnClickListener {appendString("%")}
        findViewById<Button>(id.bdot).setOnClickListener {appendString(".")}
        findViewById<Button>(id.bdel).setOnClickListener {removeLast()}
        findViewById<Button>(id.bright).setOnClickListener {appendString(")")}
        findViewById<Button>(id.bleft).setOnClickListener {appendString("(")}
        findViewById<Button>(id.bCalc).setOnClickListener {calculate()}
    }

    private fun calculate()
    {
        var result = ExpressionBuilder(operation).build().evaluate()
        operation = result.toString()
        findViewById<TextView>(id.Result).text = operation
    }

    private fun removeLast()
    {
        operation = if(operation[operation.length-1] == 'g')
            operation.substring(0,operation.length-3)
        else if(operation.length == 1)
            ""
        else
            operation.substring(0, operation.length-1)
        findViewById<TextView>(id.Result).text = operation
    }

    private fun appendString(string: String)
    {
        operation = operation.plus(string)
        findViewById<TextView>(id.Result).text = operation
    }

    private fun resetString()
    {
        operation = ""
        findViewById<TextView>(id.Result).text = operation
    }
}