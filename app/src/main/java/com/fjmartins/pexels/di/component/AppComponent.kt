package com.fjmartins.pexels.di.component

import com.fjmartins.pexels.PexelApplication
import com.fjmartins.pexels.di.module.ActivityModule
import com.fjmartins.pexels.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ActivityModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: PexelApplication): Builder

        fun build(): AppComponent
    }

    fun inject(pexelApplication: PexelApplication)
}