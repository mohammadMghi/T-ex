package com.mm.t_ex.feature.pack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mm.t_ex.R
import com.mm.t_ex.common.TexView
import com.mm.t_ex.data.Move
import com.squareup.picasso.Picasso
import org.koin.android.viewmodel.compat.ScopeCompat.viewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PackageDetailActivity : AppCompatActivity() {
    val packageDetailViewModel: PackageDetailViewModel by viewModel { parametersOf(intent.extras) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_detail)

        val moveAdapter = MoveAdapter()


        val coverIv = findViewById<ImageView>(R.id.coverIv)
        val title = findViewById<TextView>(R.id.titleTv)
        packageDetailViewModel.packageLiveData.observe(this){
            Picasso.get().load(it.img).into(coverIv)
            title.text = it.title
        }

        val moveRec = findViewById<RecyclerView>(R.id.move_rec)

        packageDetailViewModel.workoutLiveData.observe(this){
            Log.i("PackageDetailActivity", "onCreate: $it")

            moveAdapter.moves = it[0].moves as ArrayList<Move>

            moveRec.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
            moveRec.adapter =moveAdapter
        }




    }
}