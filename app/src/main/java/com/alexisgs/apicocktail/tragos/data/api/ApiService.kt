package com.alexisgs.apicocktail.tragos.data.api

import com.alexisgs.apicocktail.tragos.data.model.Drink
import com.alexisgs.apicocktail.tragos.data.model.ListDrinks
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *  Created by Alexis Guadarrama on 29/07/20.
 */
interface ApiService {

    @GET("search.php?s=")
    suspend fun getDrinkByName(@Query("nameDrink") drinkName: String): ListDrinks

}