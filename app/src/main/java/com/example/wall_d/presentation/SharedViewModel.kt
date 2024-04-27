package com.example.wall_d.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.wall_d.presentation.model.WallpaperUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor():ViewModel() {

    private val _onClickedWallpaperItem = mutableStateOf(WallpaperUiState("", "", 0, "", "", "", "", 0))
    val onClickedWallpaperItem = _onClickedWallpaperItem

    fun updateData(newData: WallpaperUiState) {
        Log.d("share","wallpaper updated")
        _onClickedWallpaperItem.value = newData
    }
}