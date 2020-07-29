package com.alexisgs.apicocktail.common


/**
 *  Created by Alexis Guadarrama on 28/07/20.
 *
 *  Objecto de Valor
 *  Single Class  generico T
 *  son 3 estados
 *  cargando
 *  succes return data T
 *  error o fallo retur exception
 */
sealed class Resource<out T> {
    class Loading<out T> : Resource<T>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class FailSuccess<out T>(val exception: Exception) : Resource<T>()
}