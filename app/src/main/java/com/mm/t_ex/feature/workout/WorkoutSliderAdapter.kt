package com.mm.t_ex.feature.workout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mm.t_ex.data.Move

class WorkoutSliderAdapter(fragmentActivity: FragmentActivity ,val moves : List<Move>) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = moves.size

    override fun createFragment(position: Int): Fragment = MoveFragment.newInstance(moves[position])
}