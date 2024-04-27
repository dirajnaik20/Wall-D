package com.example.wall_d.di

import com.example.wall_d.domain.repository.WallpaperRepository
import com.example.wall_d.presentation.SharedViewModel
import com.example.wall_d.presentation.wallpapers.WallpaperViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object WallpaperViewModelModule {

    @Provides
    fun provideWallpaperViewModel(wallpaperRepository: WallpaperRepository): WallpaperViewModel {
        return WallpaperViewModel(wallpaperRepository)

    }
    @Provides
    fun provideSharedViewModel(): SharedViewModel {
        return SharedViewModel()

    }
}