package com.greemoid.cleanl1.app

import android.app.Application
import com.greemoid.cleanl1.di.AppComponent
import com.greemoid.cleanl1.di.AppModule
import com.greemoid.cleanl1.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}