package com.mm.t_ex.feature.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mm.t_ex.R
import com.mm.t_ex.data.Package
import com.squareup.picasso.Picasso

class PackageAdapter(private val packages : List<Package>) :
    RecyclerView.Adapter<PackageAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title : TextView = view.findViewById(R.id.titleText)
        var time : TextView = view.findViewById(R.id.timeText);
        var imageCover : ImageView = view.findViewById(R.id.imgCover)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.package_item_rec, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         Picasso.get().load(packages[position].img).into(holder.imageCover)
         holder.time.text = packages[position].duration
         holder.title.text = packages[position].title
    }

    override fun getItemCount(): Int = packages.size
}