package com.example.eletriccar_app.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.eletriccar_app.R
import com.example.eletriccar_app.data.CarFactory
import com.example.eletriccar_app.ui.adapter.CarAdapter

class MainActivity : AppCompatActivity() {
    lateinit var btnAvancar: Button
    lateinit var listaCarros: RecyclerView


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
        listaCarros = findViewById(R.id.rv_car_list)

    }

    fun setupList(){
       val adapter = CarAdapter(CarFactory.list)
       listaCarros.adapter = adapter

    }
    private fun setupListeners() {
        btnAvancar.setOnClickListener {
          startActivity(Intent(this, CalcularAutonomiaActivity::class.java))
        }
    }


}