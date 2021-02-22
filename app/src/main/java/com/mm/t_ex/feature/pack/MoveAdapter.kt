package com.mm.t_ex.feature.pack

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.mm.t_ex.R
import com.mm.t_ex.data.Move
import com.squareup.picasso.Picasso

class MoveAdapter(private val moves : List<Move>) : RecyclerView.Adapter<MoveAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imgView : ImageView = view.findViewById(R.id.imgMoveTv)
        var title : TextView = view.findViewById(R.id.titleTv)
        var timeTv : TextView = view.findViewById(R.id.timeMoveTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.move_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.title.setText(moves[position].title)
         Picasso.get().load("http://10.0.2.2:8000/image/" + moves[position].file).into(holder.imgView)
         holder.timeTv.text = moves[position].description
    }

    override fun getItemCount(): Int = moves.size


}