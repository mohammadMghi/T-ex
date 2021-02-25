package com.mm.t_ex.feature.pack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mm.t_ex.R
import com.mm.t_ex.common.EXTRA_KEY_DATA
import com.mm.t_ex.common.TexView
import com.mm.t_ex.data.Duration
import com.mm.t_ex.data.Move
import com.mm.t_ex.data.Package as Pack
import com.mm.t_ex.data.Workout
import com.mm.t_ex.feature.workout.WorkoutSlideActivity
import com.squareup.picasso.Picasso
import org.koin.android.viewmodel.compat.ScopeCompat.viewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PackageDetailActivity : AppCompatActivity() {
    val packageDetailViewModel: PackageDetailViewModel by viewModel { parametersOf(intent.extras) }
    var workout = ArrayList<Workout>()
    var btnStart : Button? = null
    var moves : ArrayList<Move>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_detail)

        val moveAdapter = MoveAdapter()
        btnStart = findViewById<Button>(R.id.btnStart)
        val coverIv = findViewById<ImageView>(R.id.coverIv)
        val title = findViewById<TextView>(R.id.titleTv)
        val timePackageTv = findViewById<TextView>(R.id.timePackageTv)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        packageDetailViewModel.packageLiveData.observe(this){
            Picasso.get().load(it.img).into(coverIv)
            title.text = it.title
            timePackageTv.text = it.duration
        }

        val moveRec = findViewById<RecyclerView>(R.id.move_rec)

        packageDetailViewModel.workoutLiveData.observe(this){
            Log.i("PackageDetailActivity", "onCreate: $it")
            moves = it[0].moves as ArrayList<Move>

            moveAdapter.moves = it[0].moves as ArrayList<Move>

            moveRec.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
            moveRec.adapter =moveAdapter
        }

        btnStart!!.setOnClickListener {
            btnStart!!.visibility = View.GONE
            packageDetailViewModel.downloadfile()
        }

        packageDetailViewModel.progressBarLiveData.observe(this){
            progressBar.progress = it
        }

        packageDetailViewModel.onCompleteLiveData.observe(this){
            startActivity(Intent(this,WorkoutSlideActivity::class.java).apply {
                putParcelableArrayListExtra(EXTRA_KEY_DATA ,moves)
            })
        }

    }

    override fun onStart() {
        super.onStart()
        btnStart!!.visibility = View.VISIBLE
    }
}