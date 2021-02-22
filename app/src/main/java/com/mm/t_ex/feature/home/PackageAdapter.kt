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

class PackageAdapter() : RecyclerView.Adapter<PackageAdapter.ViewHolder>() {

    var packages = ArrayList<Package>()
       set(value) {
           field = value
           notifyDataSetChanged()
       }

    var packageOnClickListener : PackageOnClickListener? = null

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title : TextView = view.findViewById(R.id.titleText)
        var time : TextView = view.findViewById(R.id.timeText);
        var imageCover : ImageView = view.findViewById(R.id.imgCover)

        fun bindPackage(pack : Package){
            Picasso.get().load(pack.img).into(imageCover)
            time.text = pack.duration
            title.text = pack.title
            itemView.setOnClickListener{
                packageOnClickListener?.onPackageClick(pack)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.package_item_rec, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.bindPackage(packages[position])
    }

    override fun getItemCount(): Int = packages.size

    interface PackageOnClickListener{
        fun onPackageClick(pack : Package)
    }
}