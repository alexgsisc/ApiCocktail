package com.alexisgs.apicocktail.tragos.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.alexisgs.apicocktail.common.Resource
import com.alexisgs.apicocktail.tragos.domain.RepoDrink
import kotlinx.coroutines.Dispatchers

/**
 *  Created by Alexis Guadarrama on 28/07/20.
 */
class DrinkViewModel(private val repo: RepoDrink) : ViewModel() {


    val fetchListDrink = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getDrinksList())
        } catch (e: Exception) {
            emit(Resource.FailSuccess(e))
        }
    }
}