package com.alexisgs.apicocktail.tragos.data.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alexisgs.apicocktail.tragos.data.model.room.DrinkEntity

interface DrinkDao {

    @Query("SELECT * FROM drinkentity")
    suspend fun getAllFavoriteDrinkRoom(): List<DrinkEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteDrinkRoom(drinkEntity: DrinkEntity)
}