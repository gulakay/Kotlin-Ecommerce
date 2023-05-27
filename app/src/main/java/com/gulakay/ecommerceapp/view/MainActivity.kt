package com.gulakay.ecommerceapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.gulakay.ecommerceapp.R
import com.gulakay.ecommerceapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment =supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(bottomNavigationView,navHostFragment.navController)

        navController.addOnDestinationChangedListener{ controller, destination, arguments ->

            if ( destination.id == R.id.productsFragment || destination.id == R.id.basketFragment){
                bottomNavigationView.visibility = View.VISIBLE
            }else{
                bottomNavigationView.visibility= View.GONE
            }

        }
    }


}