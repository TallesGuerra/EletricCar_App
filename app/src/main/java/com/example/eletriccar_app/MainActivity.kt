package com.example.eletriccar_app

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.toString

class MainActivity : AppCompatActivity() {
    lateinit var precoKwh: EditText
    lateinit var btnCalcular: Button
    lateinit var kmPercorrido: EditText
    lateinit var resultado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setupView()
        setupListeners()
    }

    fun setupView() {
        precoKwh = findViewById(R.id.edt_precoKwh)
        btnCalcular = findViewById(R.id.btn_calcular)
        kmPercorrido = findViewById(R.id.edt_kmPercorrido)
        resultado = findViewById(R.id.tv_resultado)


    }

    private fun setupListeners() {
        btnCalcular.setOnClickListener {
            calcular()

        }
    }

    fun calcular() {
        val precoKwh_informado = precoKwh.text.toString().toFloat()
        val kmPercorrido_informado = kmPercorrido.text.toString().toFloat()

        val resultadoConsumo: Float = precoKwh_informado / kmPercorrido_informado

        resultado.text = resultadoConsumo.toString()
    }
}


