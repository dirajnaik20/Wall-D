package com.example.wall_d.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wall_d.domain.repository.WallpaperRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class WallpaperViewModel @Inject constructor(
    private val wallpaperRepository: WallpaperRepository
) : ViewModel() {

    init {
        Log.d("Diraj", "Init Block")
        initialAPICall()
    }

    private val _uiState = mutableStateOf(" ")
    val uiState: State<String> =_uiState

    private fun initialAPICall() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = wallpaperRepository.getWallpaperList(
                "minimal||vaporwave||retrowave||noir",
                "views",
                1
            )
            withContext(Dispatchers.Main){
                _uiState.value= response.data?.wallpapers?.size.toString()

            }

        }
    }
}