package com.mm.t_ex.data.repo.source

import com.mm.t_ex.data.Workout
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response

interface WorkoutDataSource {
    fun getWorkouts(workoutId : Int) : Single<List<Workout>>

    fun downloadFile() : Observable<Response<ResponseBody>>
}