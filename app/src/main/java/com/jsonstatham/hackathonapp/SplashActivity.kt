package com.jsonstatham.hackathonapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.jsonstatham.hackathonapp.Models.Auth.Auth.Status
import com.jsonstatham.hackathonapp.ui.Auth.AuthActivity
import com.jsonstatham.hackathonapp.ui.Main.MainActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SplashActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var manager : Manager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        Handler().postDelayed({
            var i : Intent
            if (manager.authStatus.value?.status == Status.LOGIN) i = Intent(this,MainActivity::class.java)
            else i = Intent(this,AuthActivity::class.java)
            startActivity(i)
            finish()
        },2000L)
    }
}