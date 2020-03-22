package com.jsonstatham.hackathonapp.di.Auth.RegistrationFragment

import androidx.lifecycle.ViewModel
import com.jsonstatham.hackathonapp.di.Auth.AuthScope
import com.jsonstatham.hackathonapp.di.ViewModelMapKey
import com.jsonstatham.hackathonapp.ui.Auth.Registration.RegistrationFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class RegistrationFragmentViewModelsModule {

    @Binds
    @RegistrationScope
    @IntoMap
    @ViewModelMapKey(RegistrationFragmentViewModel::class)
    abstract fun bindRegistrationFragmentViewModel(registrationFragmentViewModel: RegistrationFragmentViewModel) : ViewModel

}