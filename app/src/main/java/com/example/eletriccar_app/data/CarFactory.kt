package com.example.eletriccar_app.data

import com.example.eletriccar_app.domain.Carro

object CarFactory {

    val list = listOf(
        Carro(
            id = 1,
            preco = "R$ 300.000,00",
            bateria = "100Kwh",
            potencia = "200cv",
            recarga = "30min",
            urlPhoto = "www.google.com"

        ),
        Carro(
            id = 2,
            preco = "R$ 500.000,00",
            bateria = "500Kwh",
            potencia = "200cv",
            recarga = "50min",
            urlPhoto = "www.google.com"

        )
    )
}

/* VERBOS HTTP
GET - Recuperar informaçoes
Post - Para enviar informaçoes para um servidor
Delete - Para deletar algum recurso
Put - Para altera uma entidade como um todo
Path - Para alerar um atributo da entidade


 */