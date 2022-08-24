package com.ugg.movieapp.di

import com.ugg.movieapp.api.MovieAPI
import com.ugg.movieapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideMovieAPI(
        okHttpClient: OkHttpClient
    ) : MovieAPI {
        return  Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MovieAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideHTTPClient() : OkHttpClient{
        return OkHttpClient.Builder()
            .apply {
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }.build()
    }
}