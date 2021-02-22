package com.mm.t_ex.feature.pack

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.mm.t_ex.common.EXTRA_KEY_DATA
import com.mm.t_ex.common.TexViewModel
import com.mm.t_ex.data.Package

class PackageDetailViewModel(bundle: Bundle) : TexViewModel() {
    val packageLiveData = MutableLiveData<Package>()
    init {
        packageLiveData.value = bundle.getParcelable(EXTRA_KEY_DATA)


    }
}