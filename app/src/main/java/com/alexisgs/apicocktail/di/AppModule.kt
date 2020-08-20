package com.alexisgs.apicocktail.di

import android.content.Context
import androidx.room.Room
import com.alexisgs.apicocktail.common.data.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 *  Created by Alexis Guadarrama on 20/08/20.
 *
 *  Donde van a vivir las instancias @InstallIn
 *  ApplicationComponent persiste mientras vive la aplicacion el ciclo de vida de la applicacion
 */

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    //Provides que provee de una instancia puede generar varias instancias si solo se pone @Provides
    //Para generar instancias unicas se deve anotar con Singleton
    @Singleton
    @Provides
    fun provideRoomInstance(@ApplicationContext context: Context) = Room.databaseBuilder(
        context.applicationContext,
        AppDataBase::class.java,
        "drink_dao"
    ).build()

    @Singleton
    @Provides
    fun provideDrinkDao(db: AppDataBase) = db.drinkDao()
}