package com.mm.t_ex.feature.pack

import android.os.Bundle
import android.util.Log
import android.util.Pair
import androidx.lifecycle.MutableLiveData
import com.mm.t_ex.common.BASE_PATH
import com.mm.t_ex.common.EXTRA_KEY_DATA
import com.mm.t_ex.common.Helper
import com.mm.t_ex.common.TexViewModel
import com.mm.t_ex.data.Package
import com.mm.t_ex.data.Workout
import com.mm.t_ex.data.repo.WorkoutRepository
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.io.*


class PackageDetailViewModel(bundle: Bundle ,val workoutRepository: WorkoutRepository) : TexViewModel() {
    val packageLiveData = MutableLiveData<Package>()
    val workoutLiveData = MutableLiveData<List<Workout>>()
    val progressBarLiveData = MutableLiveData<Int>()
    val onCompleteLiveData = MutableLiveData<Boolean>()
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

    fun downloadfile(){
        workoutRepository.downloadFile(packageLiveData.value!!.compressed_file).
        flatMap {
            var inputStream : InputStream? = null
            var outputStream : OutputStream? = null
            val file = File(BASE_PATH, packageLiveData.value!!.compressed_file)
            try {
                inputStream = it.body()?.byteStream()
                outputStream = FileOutputStream(file)

                val data = ByteArray(4096)
                val fileSize: Long = it.body()!!.contentLength()
                var count:Int? = null
                var progress:Int = 0

                while (inputStream!!.read(data).also { count = it } != -1) {
                    outputStream.write(data, 0, count!!)
                    progress += count!!
                    val pairs = Pair<Int, Long>(progress, fileSize)


                    progressBarLiveData.postValue(((progress.toFloat() / fileSize) * 100).toInt())
                }
                outputStream.flush()

                io.reactivex.Observable.just(file);
            } catch (e: IOException) {
                e.printStackTrace()
                io.reactivex.Observable.error(e);
            }


        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : io.reactivex.Observer<File?> {
                override fun onSubscribe(d: Disposable) {
                    compositeDisposable?.add(d)
                }

                override fun onNext(file: File) {
                    Log.d("downloadZipFile", "File downloaded to " + file.absolutePath)
                }

                override fun onError(e: Throwable) {
                    Log.d("downloadZipFile", "Error " + e.message)
                }

                override fun onComplete() {
                    onCompleteLiveData.value = true
                    Helper.unpackZip(BASE_PATH,packageLiveData.value!!.compressed_file)
                }

            })
    }
}