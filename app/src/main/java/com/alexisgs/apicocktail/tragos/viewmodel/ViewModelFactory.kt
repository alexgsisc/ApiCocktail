package com.alexisgs.apicocktail.tragos.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alexisgs.apicocktail.tragos.domain.RepoDrink

/**
 *  Created by Alexis Guadarrama on 28/07/20.
 */
class ViewModelFactory(private val repoDrink: RepoDrink) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(RepoDrink::class.java).newInstance(repoDrink)
    }
}