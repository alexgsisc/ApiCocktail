package com.alexisgs.apicocktail.tragos.data

import com.alexisgs.apicocktail.common.Resource
import com.alexisgs.apicocktail.common.RetrofitClient
import com.alexisgs.apicocktail.tragos.data.model.Drink

/**
 *  Created by Alexis Guadarrama on 28/07/20.
 */
class DataSource {

    suspend fun getDrinkByName(drinkName: String): Resource<List<Drink>> {
        return Resource.Success(RetrofitClient.retrofitBuild.getDrinkByName(drinkName).drinks)
    }

}