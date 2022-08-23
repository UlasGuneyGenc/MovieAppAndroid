package com.ugg.movieapp.di

import com.ugg.movieapp.api.MovieAPI
import com.ugg.movieapp.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRepository(
        api: MovieAPI
    ) : Repository {
        return Repository(api)
    }
}