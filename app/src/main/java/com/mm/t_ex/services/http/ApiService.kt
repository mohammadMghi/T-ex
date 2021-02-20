package com.mm.t_ex.services.http

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService{

    @GET("api/v1/package/list")
    fun getPackages() : Single<List<com.mm.t_ex.data.Package>>

}

fun createApiServiceInstance() : ApiService{
    val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8000/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(ApiService::class.java)
}