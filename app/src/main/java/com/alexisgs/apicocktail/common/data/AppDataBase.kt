package com.alexisgs.apicocktail.common.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alexisgs.apicocktail.tragos.data.model.room.DrinkEntity
import com.alexisgs.apicocktail.tragos.data.dao.DrinkDao

@Database(entities = arrayOf(DrinkEntity::class), version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun drinkDao(): DrinkDao

    /***
     *  Room.inMemoryDatabaseBuilder() solo perciste los datos mientras vive la aplicacion
     *  Room.databaseBuilder() se guarda en disco
     */
    //Creacion de singleton. persiste la instanci en toda la aplicacion para no tener problemas de cocurrencia
    companion object {
        private var INSTANCE_DATA: AppDataBase? = null

        fun getDataBase(context: Context): AppDataBase {
            INSTANCE_DATA = INSTANCE_DATA ?: Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "drinkentity"
            ).build()

            return INSTANCE_DATA!!
        }

        fun destroyInstance() {
            INSTANCE_DATA = null
        }

    }
}