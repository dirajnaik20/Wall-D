package com.example.wall_d.data.repository

import android.util.Log
import retrofit2.HttpException
import com.example.wall_d.data.WallHeavenApi
import com.example.wall_d.data.local_data.BookmarkWallpaper
import com.example.wall_d.data.local_data.WallpaperDAO
import com.example.wall_d.data.mapper.toMainResponseInfo
import com.example.wall_d.domain.model.MainResponseInfo
import com.example.wall_d.domain.repository.WallpaperRepository
import com.example.wall_d.utils.Constants
import com.example.wall_d.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WallpaperRepositoryImpl @Inject constructor(
    private val wallHeavenApi: WallHeavenApi,
    private val dao: WallpaperDAO
) : WallpaperRepository {

    companion object {
        private val TAG = WallpaperRepositoryImpl::class.java.simpleName
//        private val TAG = "Diraj"
    }

    override suspend fun getPopularWallpaperList(
        page: Int
    ): Resource<MainResponseInfo> {
        return try {

            Log.d(TAG, "REQ ==> getWallpaperList() ==> $page")
            val response = wallHeavenApi.getImageList(
                query = Constants.queryParamPopular,
                sorting = Constants.sortingPopular,
                page = page
            )
            Log.d(TAG, "RESP <== getWallpaperList() <== $response")

            val data = response.toMainResponseInfo()
            Resource.Success(data = data)

        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Error("getWallpaperList() => Failed api request")
        }
    }


    override suspend fun getNewWallpaperList(page: Int): Resource<MainResponseInfo> {
        return try {

            Log.d(TAG, "REQ ==> getWallpaperList() ==> $page")
            val response = wallHeavenApi.getImageList(
                query = Constants.queryParamNew,
                sorting = Constants.sortingNew,
                page = page
            )
            Log.d(TAG, "RESP <== getWallpaperList() <== $response")

            val data = response.toMainResponseInfo()
            Resource.Success(data = data)

        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Error("getWallpaperList() => Failed api request")
        }
    }

    override suspend fun saveWallpaper(bookmarkWallpaper: BookmarkWallpaper) {
        dao.saveWallpaper(bookmarkWallpaper)
    }

    override suspend fun deleteWallpaper(bookmarkWallpaper: BookmarkWallpaper) {
        dao.deleteWallpaper(bookmarkWallpaper)
    }

    override fun getSavedWallpaper(): Flow<List<BookmarkWallpaper>>{
        return dao.getAllWallpapers()
    }

}