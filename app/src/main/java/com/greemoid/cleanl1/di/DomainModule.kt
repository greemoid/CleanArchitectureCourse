package com.greemoid.cleanl1.di

import com.greemoid.cleanl1.domain.repositories.UserRepository
import com.greemoid.cleanl1.domain.usecases.GetUserName
import com.greemoid.cleanl1.domain.usecases.SaveUserName
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetUserName(userRepository: UserRepository): GetUserName {
        return GetUserName(userRepository = userRepository)
    }


    @Provides
    fun provideSaveUserName(userRepository: UserRepository): SaveUserName {
        return SaveUserName(userRepository = userRepository)
    }

}