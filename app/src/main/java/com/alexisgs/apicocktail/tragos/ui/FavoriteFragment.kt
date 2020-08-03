package com.alexisgs.apicocktail.tragos.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexisgs.apicocktail.R
import com.alexisgs.apicocktail.common.Resource
import com.alexisgs.apicocktail.common.data.AppDataBase
import com.alexisgs.apicocktail.tragos.data.DataSourceImp
import com.alexisgs.apicocktail.tragos.data.model.Drink
import com.alexisgs.apicocktail.tragos.domain.RepoDrinkImpl
import com.alexisgs.apicocktail.tragos.ui.adapter.DrinkRecyclerView
import com.alexisgs.apicocktail.tragos.viewmodel.DrinkViewModel
import com.alexisgs.apicocktail.tragos.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_favorite_.*

class FavoriteFragment : Fragment(), DrinkRecyclerView.AdapterRecyclerView {

    private val viewModelDrink by viewModels<DrinkViewModel> {
        ViewModelFactory(RepoDrinkImpl(DataSourceImp(AppDataBase.getDataBase(requireActivity().applicationContext))))
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

        rv_favorite.layoutManager = LinearLayoutManager(this!!.context)
        viewModelDrink.getAllDrinkFavorites().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    Log.d("ListFavorite", result.data.toString())
                    val listDrink = result.data.map {
                        Drink(it.idDrink, it.image, it.name, it.descriptions, it.hasAlcoholic)
                    }
                    rv_favorite.adapter = DrinkRecyclerView(requireContext(), listDrink, this)
                }
                is Resource.FailSuccess -> {
                }
            }
        })
    }

    override fun viewsClickItem(result: Drink, position: Int) {
        viewModelDrink.deleteDrinkFavorite(result)
        rv_favorite.adapter?.notifyItemRemoved(position)
        rv_favorite.adapter!!.notifyDataSetChanged()
    }


}