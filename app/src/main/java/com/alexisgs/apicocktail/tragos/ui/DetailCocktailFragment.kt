package com.alexisgs.apicocktail.tragos.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.alexisgs.apicocktail.R
import com.alexisgs.apicocktail.common.data.AppDataBase
import com.alexisgs.apicocktail.tragos.data.DataSource
import com.alexisgs.apicocktail.tragos.data.model.Drink
import com.alexisgs.apicocktail.tragos.data.model.room.DrinkEntity
import com.alexisgs.apicocktail.tragos.domain.RepoDrinkImpl
import com.alexisgs.apicocktail.tragos.viewmodel.DrinkViewModel
import com.alexisgs.apicocktail.tragos.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.fragment_deatil_cocktail.*
import kotlinx.android.synthetic.main.item_drink.view.*

/**
 * Created by Alexis Guadarrama on 28/07/20.
 */

class DetailCocktailFragment : Fragment() {
    private lateinit var drink: Drink
    private val drinkViewModel by viewModels<DrinkViewModel> {
        ViewModelFactory(RepoDrinkImpl(DataSource(AppDataBase.getDataBase(requireActivity().applicationContext))))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireArguments().let {
            drink = it.getParcelable("KEY_DRINK")!!
            Log.d(TAG, drink.toString())
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_deatil_cocktail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDataFragment()
    }


    private fun setDataFragment() {
        Glide.with(requireContext())
            .load(drink.image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.drawable.ic_cloud_download)
            .into(img_detail_avatar)
        tv_detail_title.text = drink.name
        tv_detail_description.text = drink.descriptions
        tv_detail_has_alcoholic.text =
            if (drink.hasAlcoholic == "Alcoholic") getString(R.string.drink_with_alcohol) else getString(
                R.string.soft_drink
            )

        btn_detail_save.setOnClickListener {
            drinkViewModel.insertDrink(
                DrinkEntity(
                    drink.idDrink,
                    drink.image,
                    drink.name,
                    drink.descriptions,
                    drink.hasAlcoholic
                )
            )
            Toast.makeText(requireContext(), "Save drink in favorites", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        val TAG = DetailCocktailFragment::class.java.canonicalName
    }

}