package com.mm.t_ex

import android.app.Application
import com.mm.t_ex.data.repo.PackageRepository
import com.mm.t_ex.data.repo.PackageRepositoryImpl
import com.mm.t_ex.data.repo.source.PackageLocalDataSource
import com.mm.t_ex.data.repo.source.PackageRemoteDataSource
import com.mm.t_ex.feature.home.HomeViewModel
import com.mm.t_ex.services.http.ApiService
import com.mm.t_ex.services.http.createApiServiceInstance
import io.reactivex.Single
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App:Application() {
    override fun onCreate() {
        super.onCreate()

        val myModules = module {
            single<ApiService> { createApiServiceInstance() }

            factory<PackageRepository> { PackageRepositoryImpl(PackageLocalDataSource() ,
                PackageRemoteDataSource(get())
            ) }

            viewModel { HomeViewModel(get()) }
        }

        startKoin {
            androidContext(this@App)
            modules(myModules)
        }
    }
}