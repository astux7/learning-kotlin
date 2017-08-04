package com.example.astux7.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var op = "*"
    var oldNumber = ""
    var isNewOp = true
    fun buNumberEvent(view:View){
        if(isNewOp){
            editShowText.setText("")
        }
        isNewOp = false
        val buSelected = view as Button
        var buClickValue:String = editShowText.text.toString()
        when(buSelected.id){
            bu0.id->{
                buClickValue+="0"
            }
            bu1.id->{
                buClickValue+="1"
            }
            bu2.id->{
                buClickValue+="2"
            }
            bu3.id->{
                buClickValue+="3"
            }
            bu4.id->{
                buClickValue+="4"
            }
            bu5.id->{
                buClickValue+="5"
            }
            bu6.id->{
                buClickValue+="6"
            }
            bu7.id->{
                buClickValue+="7"
            }
            bu8.id->{
                buClickValue+="8"
            }
            bu9.id->{
                buClickValue+="9"
            }
            buDot.id->{
                buClickValue+="."
            }
            buPlusMinus.id->{
                buClickValue="-"+buClickValue
            }
        }
        editShowText.setText(buClickValue)
        isNewOp=true
    }

    fun buOpEvent(view: View){
        val buSelected = view as Button
        when(buSelected.id) {
            buMul.id-> {
               op = "*"
            }
            buDiv.id-> {
                op = "/"
            }
            buAdd.id-> {
                op = "+"
            }
            buSub.id-> {
                op = "-"
            }
        }
        oldNumber = editShowText.text.toString()
        isNewOp=true
    }

    fun buEqlEvent(view: View){

        var newNumber = editShowText.text.toString().toDouble()
        var finalNumber:Double?=null
        when(op){
            "*"->{
                finalNumber = oldNumber.toDouble()*newNumber
            }
            "/"->{
                finalNumber = oldNumber.toDouble()/newNumber
            }
            "+"->{
                finalNumber = oldNumber.toDouble()+newNumber
            }
            "-"->{
                finalNumber = oldNumber.toDouble()-newNumber
            }
        }
        editShowText.setText(finalNumber.toString())
        isNewOp=true
    }
}
