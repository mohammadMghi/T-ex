package com.mm.t_ex.feature.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

        val recyclerView = view.findViewById<RecyclerView>(R.id.package_rec)

        homeViewModel.packageProgressBarLiveData.observe(viewLifecycleOwner){
            setProgressIndicator(it)
        }

        homeViewModel.packageLiveData.observe(viewLifecycleOwner){
            val packageAdapter = PackageAdapter(it)
            recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            recyclerView.adapter = packageAdapter
            Log.i("HomeFragment", "onViewCreated: $it")

        }
    }
}