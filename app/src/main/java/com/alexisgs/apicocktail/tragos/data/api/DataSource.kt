package com.alexisgs.apicocktail.tragos.data.api

import com.alexisgs.apicocktail.common.Resource
import com.alexisgs.apicocktail.tragos.data.model.Drink

/**
 *  Created by Alexis Guadarrama on 28/07/20.
 */
class DataSource {

    private val listDrink = listOf(
        Drink(
            "https://www.thecocktaildb.com/images/media/drink/juhcuu1504370685.jpg",
            "Margarita",
            "Con Azucar, Tequila y Limon"
        ),
        Drink(
            "https://www.thecocktaildb.com/images/media/drink/wysqut1461867176.jpg",
            "Paloma",
            "Squert y Agua Mineral, Limon, Sal y Tequila"
        ),
        Drink(
            "https://www.thecocktaildb.com/images/media/drink/juhcuu1504370685.jpg",
            "Charo Negro",
            "Tequila con Cola y hielos"
        ),
        Drink(
            "https://www.thecocktaildb.com/images/media/drink/rtpxqw1468877562.jpg",
            "Caragillo",
            "Cafe con Licor 43 y Hielos"
        )
    )

    //Convierte la lista en un Resourse
    fun getListDrink(): Resource<List<Drink>> {
        return Resource.Success(listDrink)
    }


}