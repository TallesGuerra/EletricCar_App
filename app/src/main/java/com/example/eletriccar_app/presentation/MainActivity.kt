package com.example.eletriccar_app.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.eletriccar_app.R

class MainActivity : AppCompatActivity() {
    lateinit var btnAvancar: Button
    lateinit var lista: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setupView()
        setupListeners()
        setupList()
    }

    fun setupView() {
        btnAvancar = findViewById(R.id.btn_avancar)
        lista = findViewById(R.id.rv_car_list)

    }

    fun setupList(){
        val dados = arrayOf(
            "Macarrão", "Arroz", "Feijão"
        )

        lista.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dados)
    }
    private fun setupListeners() {
        btnAvancar.setOnClickListener {
          startActivity(Intent(this, CalcularAutonomiaActivity::class.java))
        }
    }


}