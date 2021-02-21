package com.mm.t_ex.feature.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mm.t_ex.R
import com.mm.t_ex.common.TexFragment

class ProfileFragment : TexFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile , container , false)
    }
}