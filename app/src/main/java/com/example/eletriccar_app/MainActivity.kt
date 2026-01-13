package com.example.eletriccar_app

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var precoKwh: EditText
    lateinit var btnCalcular: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setupView()
        setupListeners()
    }

    fun setupView() {
        precoKwh = findViewById(R.id.edtit_text_precoKwh)
        btnCalcular = findViewById(R.id.btn_calcular)

    }

    private fun setupListeners() {
        btnCalcular.setOnClickListener {
            val precoKwh_informado = precoKwh.text
            Log.d("precoKwh", precoKwh_informado.toString())

        }
    }

}