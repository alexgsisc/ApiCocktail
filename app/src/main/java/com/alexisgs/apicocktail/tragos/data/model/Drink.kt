package com.alexisgs.apicocktail.tragos.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 *  Created by Alexis Guadarrama on 28/07/20.
 */
@Parcelize
data class Drink(
    @SerializedName("strDrinkThumb")
    val image: String = "",
    @SerializedName("strDrink")
    val name: String = "",
    @SerializedName("strInstructions")
    val descriptions: String = ""
) : Parcelable


data class ListDrinks(
    @SerializedName("drinks")
    val drinks: List<Drink>
)
