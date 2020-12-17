package com.fjmartins.pexels.di.module

import com.fjmartins.pexels.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeMainActivity(): MainActivity
}