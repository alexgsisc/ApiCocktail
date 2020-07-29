package com.alexisgs.apicocktail.tragos.domain

import com.alexisgs.apicocktail.common.Resource
import com.alexisgs.apicocktail.tragos.data.api.DataSource
import com.alexisgs.apicocktail.tragos.data.model.Drink

/**
 *  Created by Alexis Guadarrama on 28/07/20.
 */
class RepoDrinkImpl(private val dataSource: DataSource) : RepoDrink {

    override fun getDrinksList(): Resource<List<Drink>> {
        return dataSource.getListDrink()
    }
}