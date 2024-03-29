package com.alexisgs.apicocktail.tragos.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 *  Created by Alexis Guadarrama on 28/07/20.
 */
@Parcelize
data class Drink(
    @SerializedName("idDrink")
    val idDrink: String = "",
    @SerializedName("strDrinkThumb")
    val image: String = "",
    @SerializedName("strDrink")
    val name: String = "",
    @SerializedName("strInstructions")
    val descriptions: String = "",
    @SerializedName("strAlcoholic")
    val hasAlcoholic: String = ""
) : Parcelable


data class ListDrinks(
    @SerializedName("drinks")
    val drinks: List<Drink>
)
