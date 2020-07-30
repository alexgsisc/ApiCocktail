package com.alexisgs.apicocktail.tragos.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *  Created by Alexis Guadarrama on 28/07/20.
 */
@Parcelize
data class Drink(
    val image: String = "",
    val name: String = "",
    val descriptions: String = ""
):Parcelable
