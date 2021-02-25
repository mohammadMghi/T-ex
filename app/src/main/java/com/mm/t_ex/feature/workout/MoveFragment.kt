package com.mm.t_ex.feature.workout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.mm.t_ex.R
import com.mm.t_ex.common.BASE_PATH
import com.mm.t_ex.common.EXTRA_KEY_DATA
import com.mm.t_ex.data.Move
import java.lang.IllegalStateException

class MoveFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_move , container , false)
        val move = requireArguments().getParcelable<Move>(EXTRA_KEY_DATA) ?: throw IllegalStateException("Move can not be null")
        val moveIv = view.findViewById<ImageView>(R.id.moveIv)
        Glide.with(this).load(BASE_PATH + move.file).into(moveIv)
        return view
    }

    companion object{
        fun newInstance(move : Move) : MoveFragment
        {
            return MoveFragment().apply {
                 arguments = Bundle().apply {
                    putParcelable(EXTRA_KEY_DATA , move)
                }
            }
        }
    }
}