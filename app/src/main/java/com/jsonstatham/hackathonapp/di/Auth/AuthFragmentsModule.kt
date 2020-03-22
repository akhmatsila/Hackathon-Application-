package com.jsonstatham.hackathonapp.di.Auth

import com.jsonstatham.hackathonapp.di.Auth.AuthFragment.AuthFragmentModule
import com.jsonstatham.hackathonapp.di.Auth.AuthFragment.AuthFragmentScope
import com.jsonstatham.hackathonapp.di.Auth.AuthFragment.AuthFragmentViewModelsModule
import com.jsonstatham.hackathonapp.di.Auth.RegistrationFragment.RegistrationFragmentModule
import com.jsonstatham.hackathonapp.di.Auth.RegistrationFragment.RegistrationFragmentViewModelsModule
import com.jsonstatham.hackathonapp.di.Auth.RegistrationFragment.RegistrationScope
import com.jsonstatham.hackathonapp.ui.Auth.AuthFragment.AuthFragment
import com.jsonstatham.hackathonapp.ui.Auth.Registration.RegistrationFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AuthFragmentsModule {

    @AuthFragmentScope
    @ContributesAndroidInjector(modules = [AuthFragmentModule::class,AuthFragmentViewModelsModule::class])
    abstract fun contributeAuthFragment() : AuthFragment


    @RegistrationScope
    @ContributesAndroidInjector(modules = [RegistrationFragmentModule::class,RegistrationFragmentViewModelsModule::class])
    abstract fun contributeRegistrationFragment() : RegistrationFragment
}