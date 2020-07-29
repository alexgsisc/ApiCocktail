package com.alexisgs.apicocktail.tragos.domain

import com.alexisgs.apicocktail.common.Resource
import com.alexisgs.apicocktail.tragos.data.model.Drink

/**
 *  Created by Alexis Guadarrama on 28/07/20.
 */
interface RepoDrink {
    fun getDrinksList(): Resource<List<Drink>>
}