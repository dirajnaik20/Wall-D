package com.example.wall_d.presentation.wallpapers

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wall_d.domain.repository.WallpaperRepository
import com.example.wall_d.presentation.mapper.toMainResponseUiState
import com.example.wall_d.presentation.model.MainResponseUiState
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

    private val _mainResponseUiState =
        mutableStateOf(MainResponseUiState(latestWallpapers = emptyList()))
    val mainResponseUiState: State<MainResponseUiState> = _mainResponseUiState

    private fun initialAPICall() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = wallpaperRepository.getWallpaperList(
                "minimal||vaporwave||retrowave||noir",
                "views",
                1
            )
            withContext(Dispatchers.Main) {
                _mainResponseUiState.value = response.data?.toMainResponseUiState()?:
                MainResponseUiState(latestWallpapers = listOf())
            }

        }
    }
}