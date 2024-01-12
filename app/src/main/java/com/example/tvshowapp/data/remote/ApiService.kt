package com.example.tvshowapp.data.remote

import com.example.tvshowapp.data.remote.model.actors.Actor
import com.example.tvshowapp.data.remote.model.schedule.Schedule
import com.example.tvshowapp.data.remote.model.tv_show.TvShow
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("shows")
    suspend fun getTvShows(): Response<TvShow>

    @GET("people")
    suspend fun getActors(): Response<Actor>

    @GET("schedule/full")
    suspend fun getSchedules(): Response<Schedule>
}