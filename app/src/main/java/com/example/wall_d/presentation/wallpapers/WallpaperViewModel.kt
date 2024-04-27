package com.example.wall_d.presentation.wallpapers

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wall_d.domain.repository.WallpaperRepository
import com.example.wall_d.presentation.mapper.toMainResponseUiState
import com.example.wall_d.presentation.model.MainResponseUiState
import com.example.wall_d.presentation.model.WallpaperUiState
import com.example.wall_d.presentation.wallpapers.composables.LoadingCompose
import com.example.wall_d.utils.Constants
import com.example.wall_d.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WallpaperViewModel @Inject constructor(
    private val wallpaperRepository: WallpaperRepository
) : ViewModel() {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    init {
        Log.d("Diraj", "Init Block")
        initialPopularAPICall()
        initialNewAPICall()
    }

    private var _mainResponseUiState =
        mutableStateOf(MainResponseUiState(latestWallpapers = emptyList()))
    val mainResponseUiState: State<MainResponseUiState> = _mainResponseUiState

    private var _loadingPopState = mutableStateOf(true)
    val loadingPopState = _loadingPopState

    private var _loadingNewState = mutableStateOf(true)
    val loadingNewState = _loadingNewState

    var pagePopular = mutableStateOf(1)
    private var popularListScrollPosition = mutableStateOf(1)

    var pageNew = mutableStateOf(1)
    private var newListScrollPosition = mutableStateOf(1)

    private var _popList = mutableStateOf<List<WallpaperUiState>>(emptyList())
    val popList = _popList

    private var _newList = mutableStateOf<List<WallpaperUiState>>(emptyList())
    val newList = _newList


    private fun initialPopularAPICall() {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {

            val response = wallpaperRepository.getPopularWallpaperList(
                1
            )

            if (response is Resource.Success) {
                _loadingPopState.value = false

                _mainResponseUiState.value = response.data?.toMainResponseUiState()
                    ?: MainResponseUiState(latestWallpapers = listOf())

                _popList.value = _mainResponseUiState.value.latestWallpapers
            }

            if (response is Resource.Error){
                initialPopularAPICall()

            }


        }
    }

    private fun initialNewAPICall() {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {

            val response = wallpaperRepository.getNewWallpaperList(
                1
            )

            if (response is Resource.Success) {
                _loadingNewState.value = false

                _mainResponseUiState.value = response.data?.toMainResponseUiState()
                    ?: MainResponseUiState(latestWallpapers = listOf())

                _newList.value = _mainResponseUiState.value.latestWallpapers
            }

            if (response is Resource.Error){
                initialNewAPICall()

            }


        }
    }

    fun onChangePopularScrollPosition(position: Int) {

        popularListScrollPosition.value = position

    }
    fun onChangeNewScrollPosition(position: Int) {

        newListScrollPosition.value = position

    }

    private fun incrementPagePopular() {
        pagePopular.value = pagePopular.value + 1

    }
    private fun incrementPageNew() {
        pageNew.value = pageNew.value + 1

    }

    fun getNextPopularPage() {

        viewModelScope.launch {

            if (popularListScrollPosition.value >= (pagePopular.value * Constants.PAGE_SIZE)) {
                _loadingPopState.value = true
                incrementPagePopular()
                Log.d("Page", "Page No: ${pagePopular.value}")

            }

            if (pagePopular.value > 1) {

                val response = wallpaperRepository.getPopularWallpaperList(
                    pagePopular.value
                )

                if (response is Resource.Success) {
                    _mainResponseUiState.value = response.data?.toMainResponseUiState()
                        ?: MainResponseUiState(latestWallpapers = listOf())
                    _popList.value = _mainResponseUiState.value.latestWallpapers
                }


                _loadingPopState.value = false

            }

        }

    }

    fun getNextNewPage() {

        viewModelScope.launch {

            if (newListScrollPosition.value >= (pageNew.value * Constants.PAGE_SIZE)) {
                _loadingNewState.value = true
                incrementPageNew()
                Log.d("Page", "Page No: ${pageNew.value}")

            }

            if (pageNew.value > 1) {

                val response = wallpaperRepository.getNewWallpaperList(
                    pageNew.value
                )

                if (response is Resource.Success) {
                    _mainResponseUiState.value = response.data?.toMainResponseUiState()
                        ?: MainResponseUiState(latestWallpapers = listOf())
                    _newList.value = _mainResponseUiState.value.latestWallpapers
                }

                _loadingNewState.value = false

            }

        }

    }

}


