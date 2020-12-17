package com.fjmartins.pexels.di.module

import com.fjmartins.pexels.ui.favorites.FavoritesFragment
import com.fjmartins.pexels.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeFavoritesFragment(): FavoritesFragment

}