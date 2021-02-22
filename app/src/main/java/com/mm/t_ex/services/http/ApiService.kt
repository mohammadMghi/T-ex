package com.mm.t_ex.services.http

import com.mm.t_ex.data.Workout
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Streaming

interface ApiService{

    @GET("api/v1/package/list")
    fun getPackages() : Single<List<com.mm.t_ex.data.Package>>

    @GET("api/v1/workout/find/{workout_id}")
    fun getWorkout(@Path("workout_id") workoutId : Int):Single<List<Workout>>

    @Streaming
    @GET("/files/{file}")
    fun downloadFile(@Path("file") file : String): Observable<Response<ResponseBody>>
}

fun createApiServiceInstance() : ApiService{
    val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8000/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(ApiService::class.java)
}