package com.example.wall_d.di

import com.example.wall_d.data.WallHeavenApi
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
object AppModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Provides
    @Singleton
    fun providesWallHeavenApi(okHttpClient: OkHttpClient):WallHeavenApi{
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(WallHeavenApi.BASE_URL_WALLPAPER)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WallHeavenApi::class.java)
    }
}