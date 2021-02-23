package com.mm.t_ex.data.repo.source

import com.mm.t_ex.data.Workout
import com.mm.t_ex.services.http.ApiService
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response

class WorkoutRemoteDataSource(val apiService: ApiService) : WorkoutDataSource {
    override fun getWorkouts(workoutId: Int): Single<List<Workout>>  = apiService.getWorkout(workoutId)

    override fun downloadFile(file: String): Observable<Response<ResponseBody>> = apiService.downloadFile(file)
}