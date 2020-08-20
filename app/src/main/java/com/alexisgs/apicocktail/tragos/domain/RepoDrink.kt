package com.alexisgs.apicocktail.tragos.domain

import com.alexisgs.apicocktail.common.Resource
import com.alexisgs.apicocktail.tragos.data.model.Drink
import com.alexisgs.apicocktail.tragos.data.model.room.DrinkEntity

/**
 *  Created by Alexis Guadarrama on 28/07/20.
 */
interface RepoDrink {
    suspend fun getDrinksList(drinkName: String): Resource<List<Drink>>
    suspend fun getAllDrinkFavorite(): Resource<List<DrinkEntity>>
    suspend fun insertDrinkFavorite(drinkEntity: DrinkEntity)
    suspend fun deleteDrinkFavorite(drinkEntity: DrinkEntity):Resource<List<DrinkEntity>>
}