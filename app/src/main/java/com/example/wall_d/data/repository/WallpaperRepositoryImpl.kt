package com.example.wall_d.data.repository

import android.util.Log
import retrofit2.HttpException
import com.example.wall_d.data.WallHeavenApi
import com.example.wall_d.data.mapper.toMainResponseInfo
import com.example.wall_d.domain.model.MainResponseInfo
import com.example.wall_d.domain.repository.WallpaperRepository
import com.example.wall_d.utils.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WallpaperRepositoryImpl @Inject constructor(
    private val wallHeavenApi: WallHeavenApi
) : WallpaperRepository {

    companion object{
        private val TAG = WallpaperRepositoryImpl::class.java.simpleName
//        private val TAG = "Diraj"
    }
    override suspend fun getWallpaperList(
        query: String,
        sorting: String,
        page: Int
    ): Resource<MainResponseInfo> {
        return try {

            Log.d(TAG,"REQ ==> getWallpaperList() ==> $query")
            val response = wallHeavenApi.getImageList(
                query=query,
                sorting=sorting,
                page=page
            )
            Log.d(TAG,"RESP <== getWallpaperList() <== $response")

            val data=response.toMainResponseInfo()
            Resource.Success(data=data)

        }
        catch (e:HttpException){
            e.printStackTrace()
            Resource.Error("getWallpaperList() => Failed api request")
        }
    }
}