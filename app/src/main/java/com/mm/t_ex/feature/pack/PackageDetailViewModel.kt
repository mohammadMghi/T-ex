package com.mm.t_ex.feature.pack

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mm.t_ex.common.EXTRA_KEY_DATA
import com.mm.t_ex.common.TexViewModel
import com.mm.t_ex.data.Package
import com.mm.t_ex.data.Workout
import com.mm.t_ex.data.repo.WorkoutRepository
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class PackageDetailViewModel(bundle: Bundle ,val workoutRepository: WorkoutRepository) : TexViewModel() {
    val packageLiveData = MutableLiveData<Package>()
    val workoutLiveData = MutableLiveData<List<Workout>>()
    init {
        packageLiveData.value = bundle.getParcelable(EXTRA_KEY_DATA)

        workoutRepository.getWorkouts(packageLiveData.value?.id!!)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally{

            }.subscribe(object : SingleObserver<List<Workout>>{
                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onSuccess(t: List<Workout>) {
                    workoutLiveData.value = t
                }

                override fun onError(e: Throwable) {
                    Log.e("PackageDetailViewModel", "onError: $e" )
                }

            })
    }
}