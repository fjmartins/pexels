package com.fjmartins.pexels.di.module

import androidx.room.Room
import com.fjmartins.pexels.PexelApplication
import com.fjmartins.pexels.dao.PexelDatabase
import com.fjmartins.pexels.network.PexelApi
import com.fjmartins.pexels.repository.PexelRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, RetrofitModule::class])
class ApplicationModule {

    @Provides
    @Singleton
    fun providePexelDatabase(app: PexelApplication): PexelDatabase {
        return Room.databaseBuilder(
            app.applicationContext,
            PexelDatabase::class.java, "pexel-database"
        ).build()
    }

    @Provides
    @Singleton
    fun providePexelRepository(database: PexelDatabase, pexelApi: PexelApi): PexelRepository {
        return PexelRepository(database, pexelApi)
    }
}