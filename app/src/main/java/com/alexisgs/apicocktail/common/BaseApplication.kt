package com.alexisgs.apicocktail.common

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 *  Created by Alexis Guadarrama on 19/08/20.
 *  es la clase de partida de la aplicacion es loq ue corre por detras de android mantiene las
 *  actividades es el contenedor de nuestra aplicación
 *
 *
 */
@HiltAndroidApp
class BaseApplication : Application() {

}