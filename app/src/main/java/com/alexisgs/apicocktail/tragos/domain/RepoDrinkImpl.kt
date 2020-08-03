package com.alexisgs.apicocktail.tragos.domain

import com.alexisgs.apicocktail.common.Resource
import com.alexisgs.apicocktail.tragos.data.DataSource
import com.alexisgs.apicocktail.tragos.data.DataSourceImp
import com.alexisgs.apicocktail.tragos.data.model.Drink
import com.alexisgs.apicocktail.tragos.data.model.room.DrinkEntity

/**
 *  Created by Alexis Guadarrama on 28/07/20.
 */
class RepoDrinkImpl(private val dataSource: DataSource) : RepoDrink {
    override suspend fun getDrinksList(drinkName: String): Resource<List<Drink>> {
        return dataSource.getDrinkByName(drinkName)
    }

    override suspend fun getAllDrinkFavorite(): Resource<List<DrinkEntity>> {
        return dataSource.getAllDrinkFavorites()
    }

    override suspend fun insertDrinkFavorite(drinkEntity: DrinkEntity) {
        dataSource.insertDrinkInRoom(drinkEntity)
    }

    override suspend fun deleteDrinkFavorite(drinkEntity: DrinkEntity) {
        dataSource.deleteDrinkFavorite(drinkEntity)
    }


}