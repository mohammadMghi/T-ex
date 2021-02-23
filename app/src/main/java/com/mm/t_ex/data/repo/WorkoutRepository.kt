package com.mm.t_ex.data.repo

import com.mm.t_ex.data.Workout
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response

interface WorkoutRepository {
    fun getWorkouts(workoutId : Int) : Single<List<Workout>>

    fun downloadFile(fileName : String) : Observable<Response<ResponseBody>>
}