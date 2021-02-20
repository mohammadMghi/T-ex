package com.mm.t_ex.feature.home

import androidx.lifecycle.MutableLiveData
import com.mm.t_ex.common.TexViewModel
import com.mm.t_ex.data.repo.PackageRepository
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel(val packageRepository: PackageRepository): TexViewModel() {
    val packageLiveData = MutableLiveData<List<com.mm.t_ex.data.Package>>()
    init {
        packageRepository.getPackages()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<com.mm.t_ex.data.Package>>{
                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onSuccess(t: List<com.mm.t_ex.data.Package>) {
                    packageLiveData.value = t
                }

                override fun onError(e: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }
}