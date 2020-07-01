package com.hossamelsharkawy.fastrec

import android.app.Activity
import android.view.View
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hossamelsharkawy.fastrec.core.DataControl

/**
 * Created by Hossam Elsharkawy
on 27/06/17.
 */

class FastRec<Model>(
    var rec: RecyclerView?,
    private var adapter: FastAdapter<Model>?
) {

    var dataControl: DataControl<Model> =
        DataControl(rec!!, adapter!!)

    fun reset() {
        //dataControl = null
        adapter = null
        rec = null
    }

    class Builder<Model>(private val act: Activity) {
        private lateinit var rec: RecyclerView
        private lateinit var adapter: FastAdapter<Model>

        private val defaultLayoutManager get() = LinearLayoutManager(this.act)

        private lateinit var onSetView: (itemView: View, m: Model, pos: Int) -> Unit
        private var onItemClick: ((v: View, model: Model, pos: Int) -> Unit)? = null

        private var value: IntArray? = null

        private var data: ArrayList<Model>? = null

        @LayoutRes
        private var rowId: Int = 0

        fun rec(rec: RecyclerView) = apply {
            this.rec = rec
        }

        fun row(@LayoutRes rowId: Int) = apply {
            this.rowId = rowId
        }

        fun onView(onSetView: (itemView: View, model: Model, pos: Int) -> Unit) = apply {
            this.onSetView = onSetView
        }


        fun setData(date: ArrayList<Model>) = apply {
            this.data = date
        }

        fun onItemClick(vararg value: Int, onItemClick: (v: View, model: Model, pos: Int) -> Unit) = apply {
            this.onItemClick = onItemClick
            this.value = value
        }

        fun horizontal() = apply { rec.horizontal() }

        fun build(): FastRec<Model> {
            this.adapter = FastAdapter(act, rowId, onSetView)

            if (value != null) {
                this.adapter.views = value?.toList()
                this.adapter.onItemClick = onItemClick
            }

            if (data != null) {
                adapter.setData(data!!)
            }

            this.rec.adapter = this.adapter

            if (this.rec.layoutManager == null) {
                this.rec.layoutManager = defaultLayoutManager
            }

            return FastRec(rec, adapter)
        }
    }
}

fun RecyclerView.setGrid(column: Int, orientation: Int) {
    layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, column, orientation, false)
}

fun RecyclerView.setGrid(column: Int) {
    layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, column)
}

fun RecyclerView.vertical() {
    layoutManager = LinearLayoutManager(context)
}

fun RecyclerView.horizontal() {
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
}

fun RecyclerView.setLayoutManager(orientation: Int) {
    layoutManager = LinearLayoutManager(context, orientation, false)
}