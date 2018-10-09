package com.nguyentienhao.haokn.hktshop.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.nguyentienhao.haokn.hktshop.R
import com.nguyentienhao.haokn.hktshop.model.categories.Categories
import de.hdodenhof.circleimageview.CircleImageView

class CateRecycleViewAdapter(private var context: Context,
                             private var cateList: ArrayList<Categories>?): RecyclerView.Adapter<CateRecycleViewAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return cateList!!.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val s: Categories = cateList!![p1]

        p0.name?.text = s.nameCate

        Glide.with(context)
                .asBitmap()
                .load(s.imageCate)
                .into(p0.image)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v: View = LayoutInflater.from(p0.context).inflate(R.layout.custom_categories, p0, false)

        return ViewHolder(v)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: CircleImageView? = null
        var name: TextView? = null

        init {
            image = itemView.findViewById(R.id.imgCategories)
            name = itemView.findViewById(R.id.tvNameCategories)
        }
    }
}