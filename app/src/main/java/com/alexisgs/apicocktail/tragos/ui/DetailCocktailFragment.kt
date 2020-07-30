package com.alexisgs.apicocktail.tragos.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alexisgs.apicocktail.R
import com.alexisgs.apicocktail.tragos.data.model.Drink
import kotlinx.android.synthetic.main.fragment_deatil_cocktail.*

/**
 * Created by Alexis Guadarrama on 28/07/20.
 */

class DetailCocktailFragment : Fragment() {
    private lateinit var drink: Drink

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
        tv_detail_title.text = drink!!.name
    }

    companion object {
        val TAG = DetailCocktailFragment::class.java.canonicalName
    }

}