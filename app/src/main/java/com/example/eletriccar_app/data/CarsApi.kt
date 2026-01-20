package com.example.eletriccar_app.data


import com.example.eletriccar_app.domain.Carro
import retrofit2.http.GET
import retrofit2.Call


interface CarsApi {
    @GET("cars.json")
    fun getAllCars(): Call<List<Carro>>

}