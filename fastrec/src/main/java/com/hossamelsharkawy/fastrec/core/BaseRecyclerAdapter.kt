package com.hossamelsharkawy.fastrec.core

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView


/**
 * Created by Hossam Elsharkawy
 * on 27/06/17.
 */

abstract class BaseRecyclerAdapter<Holder : RecyclerView.ViewHolder, Model>

    (context: Activity) : RecyclerView.Adapter<Holder>() {

    var inflater: LayoutInflater = context.layoutInflater

    var onItemClick: ((v: View, model: Model, pos: Int) -> Unit)? = null

    private var data: ArrayList<Model> = ArrayList()

    fun getData() = data

    val size: Int
        get() = data.size

    fun setData(data: ArrayList<Model>) {
        this.data = data
        notifyDataSetChanged()
    }


    fun addNewData(data: ArrayList<Model>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    fun addNewItem(item: Model, position: Int) {
        this.data.add(item)
        notifyItemInserted(position)
    }

    fun addNewItem(item: Model): Int {
        this.data.add(item)
        notifyItemInserted(data.size)
        return data.size - 1
    }

    fun removeItem(item: Model) {
        if (data.isEmpty()) return
        this.data.remove(item)
        notifyDataSetChanged()
    }

    fun removeItem(index: Int) {
        if (data.isEmpty()) return
        this.data.removeAt(index).also {
            notifyItemRemoved(index).also {
                notifyItemRangeChanged(index, size)
            }
        }
    }

    fun replaceData(data: ArrayList<Model>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }


    fun setDataNoNotify(data: ArrayList<Model>) {
        this.data = data
    }

    fun updateItem(pos: Int) = notifyItemChanged(pos)

    fun updateItem(pos: Int, model: Model) = notifyItemChanged(pos, model)

    operator fun get(adapterPosition: Int) = data[adapterPosition]

    override fun getItemCount() = data.size

}