package com.mm.t_ex.common

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable


abstract class TexFragment:Fragment(), TexView{
    override fun setProgressIndicator(mustShow: Boolean) {
        TODO("Not yet implemented")
    }
}
abstract class TexActivity: AppCompatActivity(), TexView{
    override fun setProgressIndicator(mustShow: Boolean) {
        TODO("Not yet implemented")
    }
}

interface TexView{
    fun setProgressIndicator(mustShow:Boolean)
}

abstract class TexViewModel:ViewModel(){
    val compositeDisposable= CompositeDisposable()
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}