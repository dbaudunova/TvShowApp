package com.example.tvshowapp.data.remote

import com.example.tvshowapp.data.remote.model.TvShow
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("shows")
    suspend fun getTvShows(): Response<TvShow>
}