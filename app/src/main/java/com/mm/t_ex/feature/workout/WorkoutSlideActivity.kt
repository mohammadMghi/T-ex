package com.mm.t_ex.feature.workout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mm.t_ex.R
import kotlinx.android.synthetic.main.activity_workout_slide.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class WorkoutSlideActivity : AppCompatActivity() {
    val workoutViewModel : WorkoutViewModel by viewModel{ parametersOf(intent.extras)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_slide)



        workoutViewModel.moveLiveData.observe(this){
            val WorkoutSliderAdapter = WorkoutSliderAdapter(this,it)
            moveViewPager.adapter = WorkoutSliderAdapter
        }
    }

}