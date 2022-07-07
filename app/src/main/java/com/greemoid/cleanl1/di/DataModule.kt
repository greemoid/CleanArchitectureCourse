package com.greemoid.cleanl1.di

import android.content.Context
import com.greemoid.cleanl1.data.repositories.UserRepositoryImpl
import com.greemoid.cleanl1.data.storage.UserStorage
import com.greemoid.cleanl1.data.storage.sharedprefs.SharedPrefUserStorage
import com.greemoid.cleanl1.domain.repositories.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }

    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }
}