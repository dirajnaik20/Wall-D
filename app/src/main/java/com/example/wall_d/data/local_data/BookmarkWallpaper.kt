package com.example.wall_d.data.local_data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wallpaper_data_table")
data class BookmarkWallpaper(

    @PrimaryKey
    @ColumnInfo(name="wallpaper_id")
    val id : String,
    @ColumnInfo(name="wallpaper_path")
    val path: String,
//    @ColumnInfo(name="wallpaper_createdAt")
//    val createdAt: String="",
//    @ColumnInfo(name="wallpaper_fileSize")
//    val fileSize: Int=0,
//    @ColumnInfo(name="wallpaper_fileType")
//    val fileType: String="",
//    @ColumnInfo(name="wallpaper_resolution")
//    val resolution: String="",
//    @ColumnInfo(name="wallpaper_url")
//    val url: String="",
//    @ColumnInfo(name="wallpaper_views")
//    val views: Int=0
)