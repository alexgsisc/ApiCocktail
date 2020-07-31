package com.alexisgs.apicocktail.tragos.data.model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drinkentity")
data class DrinkEntity(
    @PrimaryKey
    val idDrink: String,
    @ColumnInfo(name = "img_drink_url")
    val image: String = "",
    @ColumnInfo(name = "name_drink")
    val name: String = "",
    @ColumnInfo(name = "descriptions_drink")
    val descriptions: String = "",
    @ColumnInfo(name = "has_alcoholic")
    val hasAlcoholic: String = ""

)