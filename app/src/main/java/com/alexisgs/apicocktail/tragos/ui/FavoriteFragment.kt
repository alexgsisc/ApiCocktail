package com.alexisgs.apicocktail.tragos.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexisgs.apicocktail.R
import com.alexisgs.apicocktail.common.Resource
import com.alexisgs.apicocktail.common.data.AppDataBase
import com.alexisgs.apicocktail.tragos.data.DataSourceImp
import com.alexisgs.apicocktail.tragos.data.model.Drink
import com.alexisgs.apicocktail.tragos.data.model.room.DrinkEntity
import com.alexisgs.apicocktail.tragos.domain.RepoDrinkImpl
import com.alexisgs.apicocktail.tragos.ui.adapter.DinkFavoriteRecyclerView
import com.alexisgs.apicocktail.tragos.ui.adapter.DrinkRecyclerView
import com.alexisgs.apicocktail.tragos.viewmodel.DrinkViewModel
import com.alexisgs.apicocktail.tragos.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_favorite_.*

class FavoriteFragment : Fragment(), DrinkRecyclerView.AdapterRecyclerView {

    private val viewModelDrink by viewModels<DrinkViewModel> {
        ViewModelFactory(RepoDrinkImpl(DataSourceImp(AppDataBase.getDataBase(requireActivity().applicationContext))))
    }
    private lateinit var favoritesAdapter: DinkFavoriteRecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoritesAdapter = DinkFavoriteRecyclerView(requireContext(), this)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setDataInitFavorite()
    }

    private fun setDataInitFavorite() {
        viewModelDrink.getAllDrinkFavorites().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    Log.d("ListFavorite", result.data.toString())
                    val listDrink = result.data.map {
                        Drink(it.idDrink, it.image, it.name, it.descriptions, it.hasAlcoholic)
                    }
                    favoritesAdapter.setCocktailList(listDrink)
                }
                is Resource.FailSuccess -> {
                }
            }
        })
    }

    private fun setupRecyclerView() {
        rv_favorite.layoutManager = LinearLayoutManager(this!!.context)
        rv_favorite.adapter = favoritesAdapter
    }

    override fun viewsClickItem(result: Drink, position: Int) {

        viewModelDrink.deleteDrinkFavorite(
            DrinkEntity(
                result.idDrink,
                result.image,
                result.name,
                result.descriptions,
                result.hasAlcoholic
            )
        ).observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    val listDrink = result.data.map {
                        Drink(it.idDrink, it.image, it.name, it.descriptions, it.hasAlcoholic)
                    }
                    Toast.makeText(requireContext(), "Drink deleted !", Toast.LENGTH_SHORT).show()
                    favoritesAdapter.setCocktailList(listDrink)
                }
                is Resource.FailSuccess -> {
                }
            }
        })

        //viewModelDrink.deleteDrinkFavorite(result)
        //rv_favorite.adapter?.notifyItemRemoved(position)
        //rv_favorite.adapter?.notifyItemRangeRemoved(position, rv_favorite.adapter?.itemCount!!)
    }


}