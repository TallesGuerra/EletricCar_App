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
                put(COLUMN_NAME_CAR_ID, carro.id)
                put(COLUM_NAME_PRECO, carro.preco)
                put(COLUMN_NAME_POTENCIA, carro.bateria)
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
    }

    fun findCarById(id: Int): Carro{
        val dbHelper = carsDbHelper(context)
        val db = dbHelper.readableDatabase

        // Lista das colunas a serem exista no resultado da Query
        val columns = arrayOf(
            BaseColumns._ID,
            COLUMN_NAME_CAR_ID 
            COLUM_NAME_PRECO,
            COLUMN_NAME_POTENCIA,
            COLUM_NAME_BATERIA,
            COLUM_NAME_RECARGA,
            COLUM_NAME_URL_PHOTO
        )

        val filter = "$COLUMN_NAME_CAR_ID = ?"
        val filterValues = arrayOf(id.toString())

        val cursor = db.query(
            CarrosContract.CarEntry.TABLE_NAME, 
            columns, // as colunas a serem exibidas
            filter, // where(filtro)
            filterValues, // valor do where, substituindo o paramento ?
            null,
            null,
            null
        )

        var itemId: getLong = 0
        var preco = ""
        var bateria = ""
        var potencia = ""
        var recarga = ""
        var urlPhoto = ""

     
        with(cursor){
            while(moveToNexts())
                itemId = getLong(getColumnIndexOrThrow(COLUMN_NAME_CAR_ID))
                preco = getString(getColumnIndexOrThrow(COLUM_NAME_PRECO))
                bateria = getString(getColumnIndexOrThrow(COLUM_NAME_BATERIA))
                potencia = getString(getColumnIndexOrThrow(COLUMN_NAME_POTENCIA))
                recarga = getString(getColumnIndexOrThrow(COLUM_NAME_RECARGA))
                urlPhoto = getString(getColumnIndexOrThrow(COLUM_NAME_URL_PHOTO))
                      
        }
        cursor.close()
        return Carro(
                id = itemId.toInt()
                preco = preco,
                bateria = bateria,
                potencia = potencia,
                recarga = recarga,
                urlPhoto = urlPhoto,
                isFavorite = true
        )
    }  
   
    fun saveIfNotExist(carro: Carro){        
        val car = findCarById(carro.id)
        if(car.id == ID_WHEN_NO_CAR){
            save(carro)

        }
    }

    fun getAll() List<Carro>{
        val dbHelper = carsDbHelper(context)
        val db = dbHelper.readableDatabase

        // Lista das colunas a serem exista no resultado da Query
        val columns = arrayOf(
            BaseColumns._ID,
            COLUMN_NAME_CAR_ID 
            COLUM_NAME_PRECO,
            COLUMN_NAME_POTENCIA,
            COLUM_NAME_BATERIA,
            COLUM_NAME_RECARGA,
            COLUM_NAME_URL_PHOTO
        )
    
        val cursor = db.query(
            CarrosContract.CarEntry.TABLE_NAME, 
            columns, // as colunas a serem exibidas
            null, 
            null, 
            null,
            null,
            null
        )

        val carros = mutableListOf<Carro>()     
        with(cursor){
            while(moveToNexts())
                val itemId = getLong(getColumnIndexOrThrow(COLUMN_NAME_CAR_ID))
                val preco = getString(getColumnIndexOrThrow(COLUM_NAME_PRECO))
                val bateria = getString(getColumnIndexOrThrow(COLUM_NAME_BATERIA))
                val potencia = getString(getColumnIndexOrThrow(COLUMN_NAME_POTENCIA))
                val recarga = getString(getColumnIndexOrThrow(COLUM_NAME_RECARGA))
                val urlPhoto = getString(getColumnIndexOrThrow(COLUM_NAME_URL_PHOTO))
                
                carros.add(
                    id = itemId.toInt()
                    preco = preco,
                    bateria = bateria,
                    potencia = potencia,
                    recarga = recarga,
                    urlPhoto = urlPhoto,
                    isFavorite = true
                )
                        
        }
        cursor.close()
        return carros
    }  
    

    companion object{
        const val ID_WHEN_NO_CAR = 0
    }

}

