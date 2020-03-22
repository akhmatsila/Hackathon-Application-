package com.jsonstatham.hackathonapp.di.Main.MainFragments.Story

import androidx.lifecycle.ViewModel
import com.jsonstatham.hackathonapp.di.ViewModelMapKey
import com.jsonstatham.hackathonapp.ui.Main.Story.StoryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class StoryViewModelModule {

    @IntoMap
    @Binds
    @ViewModelMapKey(StoryViewModel::class)
    abstract fun bindViewModel(storyViewModel: StoryViewModel) : ViewModel
}