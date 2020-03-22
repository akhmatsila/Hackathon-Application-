package com.jsonstatham.hackathonapp.di.Main.MainFragments.About

import androidx.lifecycle.ViewModel
import com.jsonstatham.hackathonapp.di.ViewModelMapKey
import com.jsonstatham.hackathonapp.ui.Main.About.AboutViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AboutViewModelModule {
    @Binds
    @IntoMap
    @ViewModelMapKey(AboutViewModel::class)
    abstract fun bindViewModel(aboutViewModel: AboutViewModel) : ViewModel
}