package com.alexisgs.apicocktail.common

import com.alexisgs.apicocktail.tragos.data.api.ApiService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *  Created by Alexis Guadarrama on 29/07/20.
 */
object RetrofitClient {

    //https://www.thecocktaildb.com/api/json/v1/1/

    val retrofitBuild by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }
}