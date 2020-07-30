package com.alexisgs.apicocktail.tragos.data.api

import com.alexisgs.apicocktail.common.service.BaseServiceBuild
import com.alexisgs.apicocktail.tragos.data.model.ListDrinks
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *  Created by Alexis Guadarrama on 29/07/20.
 */
interface ApiService {

    @GET("search.php")
    suspend fun getDrinkByName(@Query("s") drinkName: String): ListDrinks


    class Builder : BaseServiceBuild<ApiService>() {
        override fun build(): ApiService {
            return retrofitBuild.build().create(ApiService::class.java)
        }
    }
}