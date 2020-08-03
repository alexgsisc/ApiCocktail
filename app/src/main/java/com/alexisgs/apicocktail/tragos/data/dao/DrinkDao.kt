package com.alexisgs.apicocktail.tragos.data.dao

import androidx.room.*
import com.alexisgs.apicocktail.tragos.data.model.room.DrinkEntity

@Dao
interface DrinkDao {

    @Query("SELECT * FROM drinkentity")
    suspend fun getAllFavoriteDrinkRoom(): List<DrinkEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteDrinkRoom(drinkEntity: DrinkEntity)

    @Delete
    suspend fun deleteDrink(drinkEntity: DrinkEntity)
}