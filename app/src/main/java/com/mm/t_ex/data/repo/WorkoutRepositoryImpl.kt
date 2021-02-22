package com.mm.t_ex.data.repo

import com.mm.t_ex.data.Workout
import com.mm.t_ex.data.repo.source.WorkoutRemoteDataSource
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response

class WorkoutRepositoryImpl(private val workoutRemoteDataSource: WorkoutRemoteDataSource) : WorkoutRepository {
    override fun getWorkouts(workoutId: Int): Single<List<Workout>> = workoutRemoteDataSource.getWorkouts(workoutId)

    override fun downloadFile(): Observable<Response<ResponseBody>> {
        TODO("Not yet implemented")
    }
}