package com.alexisgs.apicocktail.tragos.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer

import androidx.recyclerview.widget.LinearLayoutManager
import com.alexisgs.apicocktail.R
import com.alexisgs.apicocktail.common.Resource
import com.alexisgs.apicocktail.tragos.data.DataSource
import com.alexisgs.apicocktail.tragos.data.model.Drink
import com.alexisgs.apicocktail.tragos.domain.RepoDrinkImpl
import com.alexisgs.apicocktail.tragos.ui.adapter.DrinkRecyclerView
import com.alexisgs.apicocktail.tragos.viewmodel.DrinkViewModel
import com.alexisgs.apicocktail.tragos.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_cocktail.*
import androidx.navigation.fragment.findNavController

/**
 * Created by Alexis Guadarrama on 28/07/20.
 */
class CocktailFragment : Fragment(), DrinkRecyclerView.AdapterRecyclerView {


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
        setHasOptionsMenu(true)

        rv_drink.layoutManager = LinearLayoutManager(this!!.context)

        drinkViewModel.fetchListDrink.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    progress_bar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    progress_bar.visibility = View.GONE
                    rv_drink.adapter = DrinkRecyclerView(requireContext(), result.data, this)
                }
                is Resource.FailSuccess -> {
                    progress_bar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Ocurrio un Error", Toast.LENGTH_SHORT).show()
                }
            }

        })

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        requireActivity().menuInflater.inflate(R.menu.main_menu, menu)

        var item = menu.findItem(R.id.actions_search)
        var searchView: SearchView = item.actionView as SearchView
        searchView.queryHint = getString(R.string.hint_search)
        searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    drinkViewModel.setDrinkName(query!!)
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    return false
                }

            }
        )

        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun viewsClickItem(result: Drink) {
        val bundle = Bundle()
        bundle.putParcelable("KEY_DRINK", result)
        findNavController().navigate(R.id.detailCocktailFragment, bundle)
    }


}