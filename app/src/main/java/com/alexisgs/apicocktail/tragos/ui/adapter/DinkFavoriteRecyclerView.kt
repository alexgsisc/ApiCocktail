package com.alexisgs.apicocktail.tragos.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexisgs.apicocktail.R
import com.alexisgs.apicocktail.common.adapter.BaseViewHolder
import com.alexisgs.apicocktail.tragos.data.model.Drink
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.item_drink.view.*

/**
 *  Created by Alexis Guadarrama on 19/08/20.
 */

class DinkFavoriteRecyclerView(
    private val context: Context,
    private val viewsAdapter: DrinkRecyclerView.AdapterRecyclerView
) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    private var cocktailList = listOf<Drink>()

    fun setCocktailList(cocktailList: List<Drink>) {
        this.cocktailList = cocktailList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return ViewDataHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_drink, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is DinkFavoriteRecyclerView.ViewDataHolder -> holder.bind(cocktailList[position], position)
        }
    }

    override fun getItemCount(): Int {
        return cocktailList.size
    }

    inner class ViewDataHolder(itemView: View) : BaseViewHolder<Drink>(itemView) {
        override fun bind(item: Drink, position: Int) {
            if (itemCount > 0) {
                Log.e("DINK Position", ": $position : $item ")
                Glide.with(context)
                    .load(item.image)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.ic_cloud_download)
                    .into(itemView.img_avatar)

                itemView.tv_title.text = item.name
                itemView.tv_subtitle.text = item.descriptions
                itemView.setOnClickListener {
                    viewsAdapter.viewsClickItem(item, position)
                }
            }
        }
    }
}