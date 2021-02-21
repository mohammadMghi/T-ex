package com.mm.t_ex.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.mm.t_ex.R
import io.reactivex.disposables.CompositeDisposable


abstract class TexFragment:Fragment(), TexView{
    override val rootView: CoordinatorLayout?
        get() = view as CoordinatorLayout
    override val viewContext: Context?
        get() = context
}
abstract class TexActivity: AppCompatActivity(), TexView{
    override val rootView: CoordinatorLayout?
        get() = window.decorView.findViewById(android.R.id.content) as CoordinatorLayout
    override val viewContext: Context?
        get() = this
}

interface TexView{
    val rootView: CoordinatorLayout?
    val viewContext :Context?
    fun setProgressIndicator(mustShow:Boolean){
        rootView?.let{
            viewContext?.let { context->
                var loadingView = it.findViewById<View>(R.id.loadingView)
                if(loadingView == null && mustShow){
                    loadingView = LayoutInflater.from(context).inflate(R.layout.view_loading,it,false)
                    it.addView(loadingView)
                }

                loadingView?.visibility = if(mustShow) View.VISIBLE else View.GONE
            }

        }
    }
}

abstract class TexViewModel:ViewModel(){
    val compositeDisposable= CompositeDisposable()
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}