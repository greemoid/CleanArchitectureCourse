package com.greemoid.cleanl1.di

import android.content.Context
import com.greemoid.cleanl1.domain.usecases.GetUserName
import com.greemoid.cleanl1.domain.usecases.SaveUserName
import com.greemoid.cleanl1.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideMainViewModelFactory(
        getUserName: GetUserName,
        saveUserName: SaveUserName,
    ): MainViewModelFactory {
        return MainViewModelFactory(getUserName, saveUserName)
    }
}