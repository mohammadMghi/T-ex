package com.mm.t_ex.data.repo.source

import io.reactivex.Completable
import io.reactivex.Single

class PackageLocalDataSource : PackageDataSource {
    override fun getPackages(): Single<List<com.mm.t_ex.data.Package>> {
        TODO("Not yet implemented")
    }

    override fun getFavoritePackages(): Single<List<com.mm.t_ex.data.Package>> {
        TODO("Not yet implemented")
    }

    override fun addToFavoritePackage(): Completable {
        TODO("Not yet implemented")
    }

    override fun deleteFromFavorite(): Completable {
        TODO("Not yet implemented")
    }
}