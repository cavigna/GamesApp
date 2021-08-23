package com.example.gamesapp.di

import com.example.gamesapp.network.GamesApi
import com.example.gamesapp.repository.GamesRepository
import com.example.gamesapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // VER
//@InstallIn(GameApplication::class) // VER
object AppModule {

    @Singleton
    @Provides
    fun provideGameRepository(api: GamesApi) = GamesRepository(api)

    @Singleton
    @Provides
    fun provideGameApi(): GamesApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(GamesApi::class.java)
    }
}