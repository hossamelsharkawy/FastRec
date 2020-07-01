package com.hossamelsharkawy.fastrec

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import com.hossamelsharkawy.fastrec.core.BaseRecyclerAdapter
import com.hossamelsharkawy.fastrec.core.FastHolder

/**
 * Created by Hossam Elsharkawy
 * on 27/06/17.
 */

class FastAdapter<Model>(context: Activity, private val rowItemId: Int,
                         val onSetView: (itemView: View, m: Model, pos: Int) -> Unit)
    : BaseRecyclerAdapter<FastHolder<Model>, Model>(context) {

    var views: List<Int>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FastHolder<Model> {
        val itemView = getItemView(parent)
        return object : FastHolder<Model>(itemView) {
            override fun setView(m: Model, p: Int) {
                onSetView.invoke(itemView, m, p)
                views?.let { views ->
                    itemView.setOnClickListener {
                        onItemClick?.invoke(it, m,p)
                    }
                    views.forEach {
                        itemView.findViewById<View>(it).setOnClickListener { onItemClick?.invoke(it, m, p) }
                    }
                }
            }
        }
    }
    override fun onBindViewHolder(h: FastHolder<Model>, p: Int) = h.setView(get(p), p)
    private fun getItemView(parent: ViewGroup) = inflater.inflate(rowItemId, parent, false)

}