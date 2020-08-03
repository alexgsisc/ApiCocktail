package com.alexisgs.apicocktail.tragos.data

import com.alexisgs.apicocktail.common.Resource
import com.alexisgs.apicocktail.tragos.data.model.Drink
import com.alexisgs.apicocktail.tragos.data.model.room.DrinkEntity

interface DataSource {
    suspend fun getDrinkByName(drinkName: String): Resource<List<Drink>>
    suspend fun insertDrinkInRoom(drinkEntity: DrinkEntity)
    suspend fun getAllDrinkFavorites(): Resource<List<DrinkEntity>>
    suspend fun deleteDrinkFavorite(drinkEntity: DrinkEntity)
}