package com.jsonstatham.hackathonapp.di.Main

import androidx.lifecycle.ViewModel
import com.jsonstatham.hackathonapp.di.ViewModelMapKey
import com.jsonstatham.hackathonapp.ui.Main.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelsModule {
    @IntoMap
    @MainScope
    @ViewModelMapKey(MainActivityViewModel::class)
    @Binds
    abstract fun bindViewModel(mainActivityViewModel: MainActivityViewModel) : ViewModel
}