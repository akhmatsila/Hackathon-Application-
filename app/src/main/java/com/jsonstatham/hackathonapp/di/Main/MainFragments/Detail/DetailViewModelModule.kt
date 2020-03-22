package com.jsonstatham.hackathonapp.di.Main.MainFragments.Detail

import androidx.lifecycle.ViewModel
import com.jsonstatham.hackathonapp.di.ViewModelMapKey
import com.jsonstatham.hackathonapp.ui.Main.Detail.DetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DetailViewModelModule  {

    @IntoMap
    @Binds
    @ViewModelMapKey(DetailViewModel::class)
    abstract fun bindViewModel(detailViewModel: DetailViewModel) : ViewModel
}