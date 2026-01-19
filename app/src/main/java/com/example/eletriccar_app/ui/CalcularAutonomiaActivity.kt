package com.example.eletriccar_app.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.eletriccar_app.R

class CalcularAutonomiaActivity: AppCompatActivity() {
    lateinit var precoKwh: EditText
    lateinit var btnCalcular: Button
    lateinit var kmPercorrido: EditText
    lateinit var resultado: TextView
    lateinit var btnClose: ImageView


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcular_autonomia)
        setupView()
        setupListeners()


         // refatorar e transforma em setupCachedResult()
        private fun setupCachedResult(){
            val valorCalculado = getSharedPref()
            resultado.text = valorCalculado.toString()
        }
       
        
    }

    fun setupView() {
        precoKwh = findViewById(R.id.edt_precoKwh)
        btnCalcular = findViewById(R.id.btn_calcular)
        kmPercorrido = findViewById(R.id.edt_kmPercorrido)
        resultado = findViewById(R.id.tv_resultado)
        btnCalcular = findViewById(R.id.btn_calcular)
        btnClose = findViewById(R.id.btn_close)

    }

    private fun setupListeners() {
        btnCalcular.setOnClickListener {
            calcular()
        }

        btnClose.setOnClickListener{
            finish()
        }
    }

    fun calcular() {
        val preco = precoKwh.text.toString().toFloat()
        val km = kmPercorrido.text.toString().toFloat()
        val result = preco / km

        resultado.text = result.toString()
        saveSharedPref(result)
    }

    fun saveSharedPref(resultado : Float){
        val sharedPref = getPreferencs(Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()){
            putFloat(getString(R.string.saved_calc), resultado)
            apply()
        }
    }

    fun getSharedPref(): Float{
        val sharedPref = getPreferencs(Context.MODE_PRIVATE)
        return sharedPref.getFloat(getString(R.string.saved_calc), 0.0f)
         
    }

}