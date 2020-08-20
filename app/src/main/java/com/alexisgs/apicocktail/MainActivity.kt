package com.alexisgs.apicocktail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.alexisgs.apicocktail.tragos.data.dao.DrinkDao
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var drinkDao: DrinkDao

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //es en el encargado de orquestar la navegacion de la app
        navController = findNavController(R.id.nav_host_fragment)

        //Actions Bar
        NavigationUI.setupActionBarWithNavController(this, navController)

        Log.e("DRINKDAO", "OnCreate: ${drinkDao.hashCode()}")
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()

    }
}