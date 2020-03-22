package com.jsonstatham.hackathonapp.di.Main.MainFragments.Search

import androidx.lifecycle.ViewModel
import com.jsonstatham.hackathonapp.di.ViewModelMapKey
import com.jsonstatham.hackathonapp.ui.Main.Search.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SearchViewModelModule {

    @IntoMap
    @Binds
    @ViewModelMapKey(SearchViewModel::class)
    abstract fun bindViewModel(searchViewModel: SearchViewModel) : ViewModel

}