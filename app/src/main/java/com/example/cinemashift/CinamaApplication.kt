package com.example.cinemashift

import android.app.Application
import com.example.cinemashift.common.di.commonModule
import com.example.cinemashift.common.di.networkModule
import com.example.cinemashift.moviedetails.di.movieDetailsModule
import com.example.cinemashift.movielist.di.movieListModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CinamaApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@CinamaApplication)
            modules(
                networkModule,
                commonModule,
                movieDetailsModule,
                movieListModule
            )
        }
    }
}