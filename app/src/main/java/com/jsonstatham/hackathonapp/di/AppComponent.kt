package com.jsonstatham.hackathonapp.di

import com.jsonstatham.hackathonapp.Application
import com.jsonstatham.hackathonapp.Manager
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class
    , AppModule::class
    , ViewModelProvidersFactoryModule::class
    , ActivitiesBuilderModule::class])
interface AppComponent : AndroidInjector<Application> {

    @Component.Builder
    interface Builder {



        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}