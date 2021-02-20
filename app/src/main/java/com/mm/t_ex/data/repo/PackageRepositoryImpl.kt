package com.mm.t_ex.data.repo

import com.mm.t_ex.data.repo.source.PackageLocalDataSource
import com.mm.t_ex.data.repo.source.PackageRemoteDataSource
import io.reactivex.Completable
import io.reactivex.Single

class PackageRepositoryImpl(val packageLocalDataSource : PackageLocalDataSource,
                            val packageRemoteDataSource: PackageRemoteDataSource
) : PackageRepository {

    override fun getPackages(): Single<List<com.mm.t_ex.data.Package>> = packageRemoteDataSource.getPackages()

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