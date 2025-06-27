package com.example.vymodemo.di

import android.app.Application
import androidx.room.Room
import com.example.vymodemo.db.AppDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesAppDataBase(
        applicationContext: Application
    ): AppDatabase {
        return Room.databaseBuilder(
            context = applicationContext,
            klass = AppDatabase::class.java,
            "VYMO_DEMO"
        ).build()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class UserRepositoryModule  {

    @Binds
    @Singleton
    abstract fun bindsRepository(
        repositoryModuleImpl: RepositoryModuleImpl
    ): RepositoryModule
}