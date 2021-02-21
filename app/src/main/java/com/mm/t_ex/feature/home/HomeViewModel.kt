package com.mm.t_ex.feature.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mm.t_ex.common.TexViewModel
import com.mm.t_ex.data.repo.PackageRepository
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel(val packageRepository: PackageRepository): TexViewModel() {
    val packageLiveData = MutableLiveData<List<com.mm.t_ex.data.Package>>()
    val packageProgressBarLiveData = MutableLiveData<Boolean>()
    init {
        packageProgressBarLiveData.value = true
        packageRepository.getPackages()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally{
                packageProgressBarLiveData.value = false
            }
            .subscribe(object : SingleObserver<List<com.mm.t_ex.data.Package>>{
                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onSuccess(t: List<com.mm.t_ex.data.Package>) {
                    packageLiveData.value = t
                }

                override fun onError(e: Throwable) {
                    Log.e("HomeViewModel", "onError: $e", )
                }

            })
    }
}