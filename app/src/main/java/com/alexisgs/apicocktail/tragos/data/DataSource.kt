package com.alexisgs.apicocktail.tragos.data

import com.alexisgs.apicocktail.common.Resource
import com.alexisgs.apicocktail.common.RetrofitClient
import com.alexisgs.apicocktail.common.data.AppDataBase
import com.alexisgs.apicocktail.tragos.data.api.ApiService
import com.alexisgs.apicocktail.tragos.data.model.Drink
import com.alexisgs.apicocktail.tragos.data.model.room.DrinkEntity

/**
 *  Created by Alexis Guadarrama on 28/07/20.
 */
class DataSource(private val appDataBase: AppDataBase) {

    var apiServices: ApiService = ApiService.Builder().build()

    suspend fun getDrinkByName(drinkName: String): Resource<List<Drink>> {
        return Resource.Success(apiServices.getDrinkByName(drinkName).drinks)
    }

    suspend fun insertDrinkInRoom(drinkEntity: DrinkEntity) {
        appDataBase.drinkDao().insertFavoriteDrinkRoom(drinkEntity)
    }

    suspend fun getAllDrinkFavorites(): Resource<List<DrinkEntity>> {
        return Resource.Success(appDataBase.drinkDao().getAllFavoriteDrinkRoom())
    }

}