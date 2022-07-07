package com.greemoid.cleanl1.di

import com.greemoid.cleanl1.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}