package com.mm.t_ex.feature.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mm.t_ex.R
import com.mm.t_ex.common.TexFragment
import org.koin.android.viewmodel.compat.ViewModelCompat.viewModel
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : TexFragment() {
    val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home , container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setProgressIndicator(true)

        homeViewModel.packageProgressBarLiveData.observe(viewLifecycleOwner){
            setProgressIndicator(it)
        }

        homeViewModel.packageLiveData.observe(viewLifecycleOwner){
            Log.i("HomeFragment", "onViewCreated: $it")

        }
    }
}