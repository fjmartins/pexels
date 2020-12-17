package com.fjmartins.pexels.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fjmartins.pexels.di.ViewModelKey
import com.fjmartins.pexels.di.factory.ViewModelFactory
import com.fjmartins.pexels.ui.favorites.FavoritesViewModel
import com.fjmartins.pexels.ui.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(pairsViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoritesViewModel::class)
    abstract fun bindFavoritesViewModel(favoritesViewModel: FavoritesViewModel): ViewModel
}