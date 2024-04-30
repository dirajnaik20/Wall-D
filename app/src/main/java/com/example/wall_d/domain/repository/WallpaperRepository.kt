package com.example.wall_d.domain.repository


import com.example.wall_d.data.Dto.WallpaperDTO
import com.example.wall_d.data.local_data.BookmarkWallpaper
import com.example.wall_d.domain.model.MainResponseInfo
import com.example.wall_d.utils.Constants
import com.example.wall_d.utils.Resource
import kotlinx.coroutines.flow.Flow

interface WallpaperRepository {

    suspend fun getPopularWallpaperList(
        page: Int

    ): Resource<MainResponseInfo>

    suspend fun getNewWallpaperList(
        page: Int
    ): Resource<MainResponseInfo>

    suspend fun saveWallpaper(bookmarkWallpaper: BookmarkWallpaper)

    suspend fun deleteWallpaper(bookmarkWallpaper: BookmarkWallpaper)

    fun getSavedWallpaper(): Flow<List<BookmarkWallpaper>>


}