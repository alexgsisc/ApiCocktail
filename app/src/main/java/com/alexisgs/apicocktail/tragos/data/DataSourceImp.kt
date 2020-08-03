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
class DataSourceImp(private val appDataBase: AppDataBase) : DataSource {

    var apiServices: ApiService = ApiService.Builder().build()

    override suspend fun getDrinkByName(drinkName: String): Resource<List<Drink>> {
        return Resource.Success(apiServices.getDrinkByName(drinkName).drinks)
    }

    override suspend fun insertDrinkInRoom(drinkEntity: DrinkEntity) {
        appDataBase.drinkDao().insertFavoriteDrinkRoom(drinkEntity)
    }

    override suspend fun getAllDrinkFavorites(): Resource<List<DrinkEntity>> {
        return Resource.Success(appDataBase.drinkDao().getAllFavoriteDrinkRoom())
    }

    override suspend fun deleteDrinkFavorite(drinkEntity: DrinkEntity) {
        appDataBase.drinkDao().deleteDrink(drinkEntity)
    }

}