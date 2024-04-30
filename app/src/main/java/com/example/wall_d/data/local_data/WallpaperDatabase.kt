package com.example.wall_d.data.local_data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BookmarkWallpaper::class],version = 1)
abstract class WallpaperDatabase : RoomDatabase() {
    abstract fun wallpaperDAO(): WallpaperDAO

}
