package com.example.exhibitsloader.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.exhibitsloader.R
import com.example.exhibitsloader.adapters.viewholders.MainViewHolder
import com.example.exhibitsloader.interfaces.VerticalScrollOnClick
import com.example.exhibitsloader.models.ExhibitonsList
import kotlinx.android.synthetic.main.view_image_screen.view.*

class VerticalAdapter(val data: ExhibitonsList, val listener: VerticalScrollOnClick<ExhibitonsList.Exhibit>) :
    RecyclerView.Adapter<MainViewHolder<ExhibitonsList>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder<ExhibitonsList> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_image_screen, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(p0: MainViewHolder<ExhibitonsList>, p1: Int) {
        p0.itemView.setOnClickListener { listener.let { listener.onClickVertical(data.list[p1]) } }
        p0.itemView.exhibit_title.text = data.list[p1].title
        Glide.with(p0.itemView).load(data.list[p1].images[0]).into(p0.itemView.exhibit_photo)
    }

    override fun getItemCount(): Int {
        return data.list.size
    }
}