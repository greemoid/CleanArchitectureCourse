package com.greemoid.cleanl1.di

import com.greemoid.cleanl1.data.repositories.UserRepositoryImpl
import com.greemoid.cleanl1.data.storage.UserStorage
import com.greemoid.cleanl1.data.storage.sharedprefs.SharedPrefUserStorage
import com.greemoid.cleanl1.domain.repositories.UserRepository
import org.koin.dsl.module

val dataModule = module {
    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}