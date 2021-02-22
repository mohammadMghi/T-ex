package com.mm.t_ex.feature.pack

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView

import com.mm.t_ex.R
import com.mm.t_ex.data.Move
import com.squareup.picasso.Picasso

class MoveAdapter() : RecyclerView.Adapter<MoveAdapter.ViewHolder>() {

    var moves = ArrayList<Move>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imgView : SimpleDraweeView = view.findViewById(R.id.imgMoveTv)
        var title : TextView = view.findViewById(R.id.moveTitle)
        var timeTv : TextView = view.findViewById(R.id.timeMoveTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.move_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
          holder.title.text = moves[position].title
          holder.imgView.setImageURI(Uri.parse("http://10.0.2.2:8000/image/" + moves[position].file).toString())
          holder.timeTv.text = moves[position].duration.duration
    }

    override fun getItemCount(): Int = moves.size


}