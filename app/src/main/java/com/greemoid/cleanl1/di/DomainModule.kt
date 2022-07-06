package com.greemoid.cleanl1.di

import com.greemoid.cleanl1.domain.usecases.GetUserName
import com.greemoid.cleanl1.domain.usecases.SaveUserName
import org.koin.dsl.module

val domainModule = module {
    factory<GetUserName> {
        GetUserName(userRepository = get())
    }

    factory<SaveUserName> {
        SaveUserName(userRepository = get())
    }
}