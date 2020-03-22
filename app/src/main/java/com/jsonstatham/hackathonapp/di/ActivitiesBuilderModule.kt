package com.jsonstatham.hackathonapp.di

import com.jsonstatham.hackathonapp.SplashActivity
import com.jsonstatham.hackathonapp.di.Auth.AuthFragmentsModule
import com.jsonstatham.hackathonapp.di.Auth.AuthModule
import com.jsonstatham.hackathonapp.di.Auth.AuthScope
import com.jsonstatham.hackathonapp.di.Auth.AuthViewModelsModule
import com.jsonstatham.hackathonapp.di.Main.MainFragmentsModule
import com.jsonstatham.hackathonapp.di.Main.MainModule
import com.jsonstatham.hackathonapp.di.Main.MainScope
import com.jsonstatham.hackathonapp.di.Main.MainViewModelsModule
import com.jsonstatham.hackathonapp.ui.Auth.AuthActivity
import com.jsonstatham.hackathonapp.ui.Main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesBuilderModule {

    @AuthScope
    @ContributesAndroidInjector(modules = [AuthFragmentsModule::class,AuthModule::class,AuthViewModelsModule::class])
    abstract fun contributeAuthActivity() : AuthActivity

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity() : SplashActivity

    @MainScope
    @ContributesAndroidInjector(modules = [MainFragmentsModule::class,MainModule::class,MainViewModelsModule::class])
    abstract fun contributeMainActivity() : MainActivity

}