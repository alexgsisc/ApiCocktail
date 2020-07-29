package com.alexisgs.apicocktail.tragos.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.alexisgs.apicocktail.R
import com.alexisgs.apicocktail.tragos.data.api.DataSource
import com.alexisgs.apicocktail.tragos.domain.RepoDrinkImpl
import com.alexisgs.apicocktail.tragos.viewmodel.DrinkViewModel
import com.alexisgs.apicocktail.tragos.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_cocktail.*

/**
 * Created by Alexis Guadarrama on 28/07/20.
 */
class CocktailFragment : Fragment() {

    private val drinkViewModel by viewModels<DrinkViewModel> {
        ViewModelFactory(RepoDrinkImpl(DataSource()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cocktail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bt_next.setOnClickListener {
            findNavController().navigate(R.id.detailCocktailFragment)
        }
    }


}