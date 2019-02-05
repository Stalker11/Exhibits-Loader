package com.example.exhibitsloader.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.exhibitsloader.R
import com.example.exhibitsloader.adapters.viewholders.MainViewHolder
import com.example.exhibitsloader.interfaces.HorizontalOnClick
import kotlinx.android.synthetic.main.view_image_screen.view.*


class HorizontalAdapter(
    val data: MutableList<Pair<String, String>>,
    val listener: HorizontalOnClick<Pair<String, String>>
) : RecyclerView.Adapter<MainViewHolder<Pair<String, String>>>() {
    override fun onBindViewHolder(
        p0: MainViewHolder<Pair<String, String>>,
        p1: Int
    ) {
        p0.itemView.setOnClickListener { listener.let { listener.onClickHorizontal(data[p1]) } }
        p0.itemView.exhibit_title.text = data[p1].first
        Glide.with(p0.itemView).load(data[p1].second).into(p0.itemView.exhibit_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder<Pair<String, String>> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_image_screen, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}