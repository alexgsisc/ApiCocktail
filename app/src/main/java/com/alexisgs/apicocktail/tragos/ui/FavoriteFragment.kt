package com.alexisgs.apicocktail.tragos.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.alexisgs.apicocktail.R
import com.alexisgs.apicocktail.common.Resource
import com.alexisgs.apicocktail.common.data.AppDataBase
import com.alexisgs.apicocktail.tragos.data.DataSource
import com.alexisgs.apicocktail.tragos.domain.RepoDrinkImpl
import com.alexisgs.apicocktail.tragos.viewmodel.DrinkViewModel
import com.alexisgs.apicocktail.tragos.viewmodel.ViewModelFactory

class FavoriteFragment : Fragment() {

    private val viewModelDrink by viewModels<DrinkViewModel> {
        ViewModelFactory(RepoDrinkImpl(DataSource(AppDataBase.getDataBase(requireActivity().applicationContext))))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelDrink.getAllDrinkFavorites().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    Log.d("ListFavorite", result.data.toString())
                }
                is Resource.FailSuccess -> {
                }
            }
        })
    }


}