package com.jsonstatham.hackathonapp.di.Main

import com.jsonstatham.hackathonapp.di.Main.MainFragments.About.AboutModule
import com.jsonstatham.hackathonapp.di.Main.MainFragments.About.AboutViewModelModule
import com.jsonstatham.hackathonapp.di.Main.MainFragments.Detail.DetailModule
import com.jsonstatham.hackathonapp.di.Main.MainFragments.Detail.DetailViewModelModule
import com.jsonstatham.hackathonapp.di.Main.MainFragments.Search.SearchModule
import com.jsonstatham.hackathonapp.di.Main.MainFragments.Search.SearchViewModelModule
import com.jsonstatham.hackathonapp.di.Main.MainFragments.Settings.SettingsModule
import com.jsonstatham.hackathonapp.di.Main.MainFragments.Settings.SettingsViewModelModule
import com.jsonstatham.hackathonapp.di.Main.MainFragments.Story.StoryModule
import com.jsonstatham.hackathonapp.di.Main.MainFragments.Story.StoryViewModelModule
import com.jsonstatham.hackathonapp.di.Main.MainFragments.Subscribe.SubscribeModule
import com.jsonstatham.hackathonapp.di.Main.MainFragments.Subscribe.SubscribeViewModelModule
import com.jsonstatham.hackathonapp.ui.Main.About.AboutFragment
import com.jsonstatham.hackathonapp.ui.Main.Detail.DetailFragment
import com.jsonstatham.hackathonapp.ui.Main.Search.SearchFragment
import com.jsonstatham.hackathonapp.ui.Main.Settings.SettingsFragment
import com.jsonstatham.hackathonapp.ui.Main.Story.StoryFragment
import com.jsonstatham.hackathonapp.ui.Main.Subscribe.SubscribeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentsModule {

    @ContributesAndroidInjector(modules = [AboutModule::class,AboutViewModelModule::class])
    abstract fun contributeAboutFragment() : AboutFragment

    @ContributesAndroidInjector(modules = [SettingsModule::class, SettingsViewModelModule::class])
    abstract fun contributeSettingsFragment() : SettingsFragment

    @ContributesAndroidInjector(modules = [StoryModule::class, StoryViewModelModule::class])
    abstract fun contributesStoryFragment() : StoryFragment

    @ContributesAndroidInjector(modules = [SearchModule::class, SearchViewModelModule::class])
    abstract fun contributesSearchFragment() : SearchFragment

    @ContributesAndroidInjector(modules = [SubscribeModule::class, SubscribeViewModelModule::class])
    abstract fun contributesSubscribeFragment() : SubscribeFragment

    @ContributesAndroidInjector(modules = [DetailModule::class, DetailViewModelModule::class])
    abstract  fun contributesDetailFragment() : DetailFragment

}