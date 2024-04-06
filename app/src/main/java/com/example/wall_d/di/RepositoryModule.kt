package com.example.wall_d.di

import com.example.wall_d.data.repository.WallpaperRepositoryImpl
import com.example.wall_d.domain.repository.WallpaperRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWallpaperRepository(
        wallpaperRepositoryImpl: WallpaperRepositoryImpl
    ):WallpaperRepository
}