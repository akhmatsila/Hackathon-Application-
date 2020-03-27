package com.jsonstatham.hackathonapp.ui.Main

import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.jsonstatham.hackathonapp.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() , NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView : NavigationView
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        drawerLayout = findViewById(R.id.drawers_layout)
        navigationView = findViewById(R.id.nav_view)
        navController = Navigation.findNavController(this,R.id.fragment2)
        init()
    }



    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId) {
            R.id.nav_to_search -> {
                navController.navigate(R.id.searchFragment)
            }
            R.id.nav_to_story -> {
                navController.navigate(R.id.storyFragment)
            }
            R.id.nav_to_settings -> {
                navController.navigate(R.id.settingsFragment)
            }
            R.id.nav_to_subscribe -> {
                navController.navigate(R.id.subscribeFragment)
            }
            R.id.nav_to_about -> {
                navController.navigate(R.id.aboutFragment)
            }
        }
        p0.setChecked(true)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun init() {
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)
        NavigationUI.setupWithNavController(navigationView, navController)
        navigationView.setNavigationItemSelectedListener(this)
    }


    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,drawerLayout)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId) {
            android.R.id.home -> {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer((GravityCompat.START))
                    return true
                } else return false
            }
        }
        return super.onOptionsItemSelected(item)
    }


}
