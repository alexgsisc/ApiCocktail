package com.alexisgs.apicocktail.common.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 *  Created by Alexis Guadarrama on 29/07/20.
 */
abstract class BaseViewHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T, position: Int)
}