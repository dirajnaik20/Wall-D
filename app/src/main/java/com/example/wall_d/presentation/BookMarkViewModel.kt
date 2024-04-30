package com.example.wall_d.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.wall_d.data.local_data.BookmarkWallpaper
import com.example.wall_d.domain.repository.WallpaperRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class BookMarkViewModel @Inject constructor(
    private val repository: WallpaperRepository

) : ViewModel() {

    private var _savedWallpaperList: LiveData<List<BookmarkWallpaper>> = repository.getSavedWallpaper().asLiveData()

    val savedWallpaperList=_savedWallpaperList

    private var _isBookMark = mutableStateOf(false)
    val isBookMark = _isBookMark

    fun saveWallpaper(bookmarkWallpaper: BookmarkWallpaper) {

        viewModelScope.launch(Dispatchers.IO) {
            repository.saveWallpaper(bookmarkWallpaper)
        }


    }

    fun deleteWallpaper(bookmarkWallpaper: BookmarkWallpaper){

        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteWallpaper(bookmarkWallpaper)

        }

    }

    fun updateIsBookMark(){
        _isBookMark.value=!_isBookMark.value
    }
}