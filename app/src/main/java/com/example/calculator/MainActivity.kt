package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    private var canAddOperation = false
    private var canAddDecimal = true
    val a = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun equalsAction(view: View) {

        val expression = ExpressionBuilder(workingsTV.text.toString()).build()
        val result = expression.evaluate()
        val longresult = result.toLong()


            if (result == longresult.toDouble()) {
                answer.text = longresult.toString()
            } else {
                answer.text = result.toString()
            }
        }




    fun backSpaceAction(view: View) {
        val length = workingsTV.length()
        if (length>0){
            workingsTV.text = workingsTV.text.subSequence(0, length-1) as Editable?
        }

    }


    fun allClearAction(view: View) {
        workingsTV.setText("")
        answer.setText("")
    }


    fun operatorAction(view: View) {
        if(view is Button && canAddOperation)
        {
            workingsTV.append(view.text)
            canAddOperation = false
            canAddDecimal = true
        }

        }

    fun numberAction(view: View) {
        if(view is Button)
        {
            if(view.text == ".")
            {
                if(canAddDecimal)
                    workingsTV.append(view.text)

                canAddDecimal = false
            }
            else
                workingsTV.append(view.text)

            canAddOperation = true
        }

    }
}