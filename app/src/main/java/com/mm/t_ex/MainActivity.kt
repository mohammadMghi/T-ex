package com.mm.t_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mm.t_ex.common.TexActivity

class MainActivity : TexActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}