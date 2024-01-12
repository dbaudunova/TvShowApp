package com.example.tvshowapp.repository

import com.example.tvshowapp.data.remote.ApiService
import javax.inject.Inject

class TvShowRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getTvShows() = apiService.getTvShows()

    suspend fun getActors() = apiService.getActors()

    suspend fun getSchedules() = apiService.getSchedules()
}