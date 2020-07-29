package com.alexisgs.apicocktail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.alexisgs.apicocktail.tragos.data.api.DataSource
import com.alexisgs.apicocktail.tragos.domain.RepoDrinkImpl
import com.alexisgs.apicocktail.tragos.viewmodel.DrinkViewModel
import com.alexisgs.apicocktail.tragos.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //es en el encargado de orquestar la navegacion de la app
        navController = findNavController(R.id.nav_host_fragment)

        //Actions Bar
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()

    }
}