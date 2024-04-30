package com.example.wall_d.di

import android.content.Context
import androidx.room.Room
import com.example.wall_d.data.local_data.BookmarkWallpaper
import com.example.wall_d.data.local_data.WallpaperDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            WallpaperDatabase::class.java,
            "wallpaper_data_table"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideDao(wallpaperDatabase: WallpaperDatabase) =
        wallpaperDatabase.wallpaperDAO()

//    @Provides
//    fun provideBookmarkWallpaper()=
//        BookmarkWallpaper()



}