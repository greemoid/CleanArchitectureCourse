package com.greemoid.cleanl1.app

import android.app.Application
import com.greemoid.cleanl1.di.appModule
import com.greemoid.cleanl1.di.dataModule
import com.greemoid.cleanl1.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(androidContext = this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }


}