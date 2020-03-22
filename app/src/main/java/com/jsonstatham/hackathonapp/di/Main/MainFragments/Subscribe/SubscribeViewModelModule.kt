package com.jsonstatham.hackathonapp.di.Main.MainFragments.Subscribe

import androidx.lifecycle.ViewModel
import com.jsonstatham.hackathonapp.di.ViewModelMapKey
import com.jsonstatham.hackathonapp.ui.Main.Subscribe.SubscribeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SubscribeViewModelModule {

    @IntoMap
    @Binds
    @ViewModelMapKey(SubscribeViewModel::class)
    abstract fun bindViewModel(subscribeViewModel: SubscribeViewModel) : ViewModel

}