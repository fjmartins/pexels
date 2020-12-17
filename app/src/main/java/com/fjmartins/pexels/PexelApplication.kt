package com.fjmartins.pexels

import android.app.Application
import com.fjmartins.pexels.di.PexelInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class PexelApplication: Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        PexelInjector.init(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}