package com.greemoid.cleanl1.di

import android.content.Context
import com.greemoid.cleanl1.data.repositories.UserRepositoryImpl
import com.greemoid.cleanl1.data.storage.UserStorage
import com.greemoid.cleanl1.data.storage.sharedprefs.SharedPrefUserStorage
import com.greemoid.cleanl1.domain.repositories.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context) : UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage) : UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }


}