package com.jsonstatham.hackathonapp.di.Auth.AuthFragment

import androidx.lifecycle.ViewModel
import com.jsonstatham.hackathonapp.di.Auth.AuthScope
import com.jsonstatham.hackathonapp.di.ViewModelMapKey
import com.jsonstatham.hackathonapp.ui.Auth.AuthFragment.AuthFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthFragmentViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelMapKey(AuthFragmentViewModel::class)
    abstract fun bindFragment(authFragmentViewModel: AuthFragmentViewModel) : ViewModel
}