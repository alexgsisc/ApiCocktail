package com.alexisgs.apicocktail.tragos.viewmodel

import androidx.lifecycle.*
import com.alexisgs.apicocktail.common.Resource
import com.alexisgs.apicocktail.tragos.domain.RepoDrink
import kotlinx.coroutines.Dispatchers

/**
 *  Created by Alexis Guadarrama on 28/07/20.
 */
class DrinkViewModel(private val repo: RepoDrink) : ViewModel() {

    private val drinkData = MutableLiveData<String>()

    fun setDrinkName(drinkName: String) {
        drinkData.value = drinkName
    }

    //Primera se lanza cuando se llama
    /*val fetchListDrink = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getDrinksList("margarita"))
        } catch (e: Exception) {
            emit(Resource.FailSuccess(e))
        }
    }*/

    //trae cuando inicie por defaul margarita
    init {
        setDrinkName("margarita")
    }

    val fetchListDrink = drinkData.distinctUntilChanged().switchMap { drinkName ->
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                emit(repo.getDrinksList(drinkName))
            } catch (e: Exception) {
                emit(Resource.FailSuccess(e))
            }
        }
    }
}