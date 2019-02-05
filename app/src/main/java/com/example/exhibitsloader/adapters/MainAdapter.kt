package com.example.exhibitsloader.adapters

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exhibitsloader.R
import com.example.exhibitsloader.interfaces.HorizontalOnClick
import com.example.exhibitsloader.interfaces.VerticalScrollOnClick
import com.example.exhibitsloader.models.ExhibitonsList

class MainAdapter(
    val items: ExhibitonsList, val verticalListener: VerticalScrollOnClick<ExhibitonsList.Exhibit>
    ,val horizontalListener: HorizontalOnClick<Pair<String, String>>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val VERTICAL = 1
    private val HORIZONTAL = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View
        val holder: RecyclerView.ViewHolder
        when (viewType) {
            VERTICAL -> {
                view = inflater.inflate(R.layout.view_horizontal_scroll, parent, false)
                holder = VerticalViewHolder(view)
            }
            HORIZONTAL -> {
                view = inflater.inflate(R.layout.view_horizontal_scroll, parent, false)
                holder = HorizontalViewHolder(view)
            }

            else -> {
                view = inflater.inflate(R.layout.view_horizontal_scroll, parent, false)
                holder = HorizontalViewHolder(view)
            }
        }
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == VERTICAL)
            verticalView(holder as VerticalViewHolder)
        else if (holder.itemViewType == HORIZONTAL)
            horizontalView(holder as HorizontalViewHolder, position)
    }

    private fun verticalView(holder: VerticalViewHolder) {

        val adapter1 = VerticalAdapter(
            data = items,
            listener = verticalListener
        )
        holder.recyclerView.layoutManager = LinearLayoutManager(holder.itemView.context)
        holder.recyclerView.adapter = adapter1
    }

    private fun horizontalView(holder: HorizontalViewHolder, position: Int) {
        val list = mutableListOf<Pair<String, String>>()
        val name = items.list[position].title
        items.list[position].images.forEach {
            list.add(Pair(name, it))
        }
        val adapter = HorizontalAdapter(data = list, listener = horizontalListener)
        holder.recyclerView.layoutManager =
            LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        holder.recyclerView.adapter = adapter
    }


    override fun getItemCount(): Int {
        return items.list.size
    }

    override fun getItemViewType(position: Int): Int {
        if (items.list[position].images.size > 1) return HORIZONTAL

        return if (items.list[position].images.size == 1) VERTICAL else -1
    }

    inner class HorizontalViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var recyclerView: RecyclerView

        init {
            recyclerView = itemView.findViewById(R.id.inner_recycler)
        }
    }

    inner class VerticalViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var recyclerView: RecyclerView

        init {
            recyclerView = itemView.findViewById(R.id.inner_recycler)
        }
    }

}