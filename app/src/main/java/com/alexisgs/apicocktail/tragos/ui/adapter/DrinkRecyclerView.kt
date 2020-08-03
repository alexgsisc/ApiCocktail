package com.alexisgs.apicocktail.tragos.ui.adapter

import android.content.Context
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
 *  Created by Alexis Guadarrama on 29/07/20.
 */
class DrinkRecyclerView(
    private val context: Context,
    private val listTemp: List<Drink>,
    private val viewsAdapter: AdapterRecyclerView
) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    private var listData = mutableListOf<Drink>()

    init {
        listData.addAll(listTemp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return ViewDataHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_drink, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is ViewDataHolder -> holder.bind(listData[position], position)
        }
    }

    //inner muera la class cuando muera la class padre,usa los atributos del constructor principal
    inner class ViewDataHolder(itemView: View) : BaseViewHolder<Drink>(itemView) {
        override fun bind(item: Drink, position: Int) {
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

    interface AdapterRecyclerView {
        fun viewsClickItem(result: Drink, position: Int)
    }

}