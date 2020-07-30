package com.alexisgs.apicocktail.tragos.domain

import com.alexisgs.apicocktail.common.Resource
import com.alexisgs.apicocktail.tragos.data.model.Drink

/**
 *  Created by Alexis Guadarrama on 28/07/20.
 */
interface RepoDrink {
    suspend fun getDrinksList(drinkName: String): Resource<List<Drink>>
}