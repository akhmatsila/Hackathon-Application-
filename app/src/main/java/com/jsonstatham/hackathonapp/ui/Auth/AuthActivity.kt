package com.jsonstatham.hackathonapp.ui.Auth

import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.jsonstatham.hackathonapp.Manager
import com.jsonstatham.hackathonapp.Models.Auth.Auth.Status
import com.jsonstatham.hackathonapp.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {


    lateinit var navController: NavController
    lateinit var authCanvas: DrawerLayout

    @Inject
    lateinit var manager : Manager




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auth_activity)

        navController = Navigation.findNavController(this, R.id.fragment)
        authCanvas = findViewById(R.id.auth_canvas)

        manager.authStatus.observe(this ,  Observer {
            if (it.status == Status.LOGIN) finish()
        })


    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, authCanvas)
    }
}
