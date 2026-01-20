package com.example.eletriccar_app.data.local

import android.content.ContentValues
import android.content.Context
import android.provider.BaseColumns
import android.util.Log
import com.example.eletriccar_app.data.local.CarrosContract.CarEntry.COLUMN_NAME_BATERIA
import com.example.eletriccar_app.data.local.CarrosContract.CarEntry.COLUMN_NAME_CAR_ID
import com.example.eletriccar_app.data.local.CarrosContract.CarEntry.COLUMN_NAME_POTENCIA
import com.example.eletriccar_app.data.local.CarrosContract.CarEntry.COLUMN_NAME_PRECO
import com.example.eletriccar_app.data.local.CarrosContract.CarEntry.COLUMN_NAME_RECARGA
import com.example.eletriccar_app.data.local.CarrosContract.CarEntry.COLUMN_NAME_URL_PHOTO
import com.example.eletriccar_app.data.domain.Carro


class  CarRepository(private val context: Context) {
    fun save(carro: Carro) : Boolean {
        var isSaved = false
        
        try {
            val dbHelper = carsDbHelper(context)
            val db = dbHelper.writableDatabase

            val values = ContenValues().apply{
                put(COLUM_NAME_PRECO, carro.preco)
                put(COLUM_NAME_BATERIA, carro.bateria)
                put(COLUM_NAME_BATERIA, carro.potencia)
                put(COLUM_NAME_RECARGA, carro.recarga)
                put(COLUM_NAME_URL_PHOTO, carro.urlPhoto)
        }

         val inserted = db?.insert(CarrosContract.CarEntry.TABLE_NAME, null, values)
            if(inserted != null)
                isSaved = true

        } catch (ex: Exception) {
            ex.message?.let {
                Log.e("Erro ao inserir -> ", it)
            }
        }

        return isSaved    


    fun findCarById(id: Int){
        val dbHelper = carsDbHelper(context)
        val db = dbHelper.readableDatabase

        // Lista das colunas a serem exista no resultado da Query
        val columns = arrayOf(
            BaseColumns._ID, 
            COLUM_NAME_PRECO,
            COLUM_NAME_BATERIA,
            COLUM_NAME_BATERIA,
            COLUM_NAME_RECARGA,
            COLUM_NAME_URL_PHOTO
        )

        val filter = "${BaseColumns._ID} = ?"
        val filterValues = arrayOf(id.toString())
        
        val cursor = db.query(
            CarrosContract.CarEntry.TABLE_NAME, 
            columns,
            filter,
            id,
            null
            null,
            null
        )
    }        
}

  