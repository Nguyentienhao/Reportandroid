package com.nguyentienhao.haokn.hktshop.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.nguyentienhao.haokn.hktshop.R
import com.nguyentienhao.haokn.hktshop.model.store.Stores


class StoreRecycleViewAdapter(
        private var context: Context,
        private var storesList: ArrayList<Stores>?): RecyclerView.Adapter<StoreRecycleViewAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return storesList!!.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val s: Stores = storesList!![p1]

        p0.name?.text = s.nameStore

        Glide.with(context)
                .asBitmap()
                .load(s.imgStore)
                .into(p0.image)

    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v: View = LayoutInflater.from(p0.context).inflate(R.layout.custom_categories_stores, p0, false)
        return ViewHolder(v)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var image: ImageView? = null
        var name: TextView? = null

        init {
            image = itemView.findViewById(R.id.imgStore)
            name  = itemView.findViewById(R.id.tvNameStore)
        }
    }
}