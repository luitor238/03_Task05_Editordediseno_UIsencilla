package com.example.task05_editordediseo_uisencilla

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnCalcular : Button = findViewById(R.id.btnCalcular)
        var txtNumero1 : EditText = findViewById(R.id.txtNumero1)
        var txtNumero2 : EditText = findViewById(R.id.txtNumero2)
        var operador : EditText = findViewById(R.id.operador)
        var resultado : TextView = findViewById(R.id.resultado)


        btnCalcular.setOnClickListener {
            val num1 = txtNumero1.text.toString().toDoubleOrNull() ?: 0.0
            val num2 = txtNumero2.text.toString().toDoubleOrNull() ?: 0.0
            val operacion = operador.text.toString()

            val resultado2 = when (operacion) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> if (num2 != 0.0) num1 / num2 else Double.NaN
                else -> Double.NaN
            }

            if (resultado2.isNaN() || resultado2.isInfinite()) {
                resultado.text = "Error en la operación"
            } else {
                resultado.text = "$resultado2"
            }
        }
    }
}