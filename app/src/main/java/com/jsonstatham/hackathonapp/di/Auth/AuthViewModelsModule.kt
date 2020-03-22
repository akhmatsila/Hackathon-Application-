package com.jsonstatham.hackathonapp.di.Auth

import androidx.lifecycle.ViewModel
import com.jsonstatham.hackathonapp.di.ViewModelMapKey
import com.jsonstatham.hackathonapp.ui.Auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelsModule {
    @AuthScope
    @Binds
    @IntoMap
    @ViewModelMapKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(avm : AuthViewModel) : ViewModel
}