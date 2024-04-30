package com.example.wall_d.data.local_data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WallpaperDAO {
    @Insert
    suspend fun saveWallpaper(bookmarkWallpaper: BookmarkWallpaper)
    @Delete
    suspend fun deleteWallpaper(bookmarkWallpaper: BookmarkWallpaper)
    @Query("SELECT * FROM wallpaper_data_table")
    fun getAllWallpapers(): Flow<List<BookmarkWallpaper>>


}