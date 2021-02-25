package com.mm.t_ex.feature.workout


import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.mm.t_ex.common.EXTRA_KEY_DATA
import com.mm.t_ex.common.TexView
import com.mm.t_ex.common.TexViewModel
import com.mm.t_ex.data.Move
import com.mm.t_ex.data.Package
import com.mm.t_ex.data.Workout
import com.mm.t_ex.data.repo.WorkoutRepository

class WorkoutViewModel(bundle: Bundle) : TexViewModel() {
    val moveLiveData = MutableLiveData<ArrayList<Move>>()

    init {


         moveLiveData.value = bundle.getParcelableArrayList(EXTRA_KEY_DATA)


    }
}