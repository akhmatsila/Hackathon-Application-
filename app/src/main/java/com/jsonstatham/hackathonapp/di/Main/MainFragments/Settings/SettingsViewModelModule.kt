package com.jsonstatham.hackathonapp.di.Main.MainFragments.Settings

import androidx.lifecycle.ViewModel
import com.jsonstatham.hackathonapp.di.ViewModelMapKey
import com.jsonstatham.hackathonapp.ui.Main.Settings.SettingsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SettingsViewModelModule {

    @IntoMap
    @Binds
    @ViewModelMapKey(SettingsViewModel::class)
    abstract fun bindViewModel(settingsViewModel: SettingsViewModel) : ViewModel
}