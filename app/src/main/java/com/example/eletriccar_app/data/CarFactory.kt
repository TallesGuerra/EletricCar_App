package com.example.eletriccar_app.data

import com.example.eletriccar_app.domain.Carro

object CarFactory {

    val list = listOf(
        Carro(
            id = 1,
            preco = "R$ 300.000,00",
            bateria = "100kWh",
            potencia = "200cv",
            recarga = "30min",
            urlPhoto = "www.google.com.br",
            isFavorite = false
        ),
        Carro(
            id = 2,
            preco = "R$ 500.000,00",
            bateria = "500kWh",
            potencia = "200cv",
            recarga = "50min",
            urlPhoto = "www.google.com",
            isFavorite = false
        )
    )
}
