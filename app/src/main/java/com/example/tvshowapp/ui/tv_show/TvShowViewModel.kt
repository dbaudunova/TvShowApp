package com.example.tvshowapp.ui.tv_show

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvshowapp.data.remote.model.actors.ActorItem
import com.example.tvshowapp.data.remote.model.schedule.ScheduleItem
import com.example.tvshowapp.data.remote.model.tv_show.TvShowItem
import com.example.tvshowapp.repository.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(private val repository: TvShowRepository) : ViewModel() {

    private val _tvShowResponse = MutableLiveData<List<TvShowItem>>()
    private val _actorResponse = MutableLiveData<List<ActorItem>>()
    private val _scheduleResponse = MutableLiveData<List<ScheduleItem>>()
    val responseTvShow: LiveData<List<TvShowItem>>
        get() = _tvShowResponse
    val responseActor: LiveData<List<ActorItem>>
        get() = _actorResponse
    val scheduleResponse: LiveData<List<ScheduleItem>>
        get() = _scheduleResponse

    init {
        getAllTvShows()
        getAllActors()
        getAllSchedules()
    }

    private fun getAllSchedules() {
        viewModelScope.launch {
            repository.getSchedules().let { response ->
                if (response.isSuccessful) {
                    _scheduleResponse.postValue(response.body())
                } else {
                    Log.e("ololo", "getAllSchedules:${response.code()}")
                }
            }
        }
    }

    private fun getAllActors() {
        viewModelScope.launch {
            repository.getActors().let {
                if (it.isSuccessful) {
                    _actorResponse.postValue(it.body())
                } else {
                    Log.e("ololo", "getAllActors:${it.code()}")
                }
            }
        }
    }

    private fun getAllTvShows() = viewModelScope.launch {
        repository.getTvShows().let { response ->
            if (response.isSuccessful) {
                _tvShowResponse.postValue(response.body())
            } else {
                Log.e("ololo", "getAllTvShowsError:${response.code()}")
            }
        }
    }
}