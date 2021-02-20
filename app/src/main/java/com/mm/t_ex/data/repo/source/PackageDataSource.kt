package com.mm.t_ex.data.repo.source

import io.reactivex.Completable
import io.reactivex.Single

interface PackageDataSource {

    fun getPackages(): Single<List<com.mm.t_ex.data.Package>>

    fun getFavoritePackages() : Single<List<com.mm.t_ex.data.Package>>

    fun addToFavoritePackage() : Completable

    fun deleteFromFavorite() : Completable
}