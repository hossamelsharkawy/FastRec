package com.hossamelsharkawy.fastrec.core

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Hossam Elsharkawy
0201099197556
on 04/03/19.  time :16:43

 */


class DataControl<Model>(
    private val rec: RecyclerView,
    private val adapter: BaseRecyclerAdapter<FastHolder<Model>, Model>
) {
    fun setData(data: ArrayList<Model>) = adapter.setData(data)

    fun addNewData(arrayList: ArrayList<Model>) = adapter.addNewData(arrayList)

    fun replaceData(arrayList: ArrayList<Model>) = adapter.replaceData(arrayList)

    fun getData() = adapter.getData()

    fun addNewItem(item: Model): Int {
        val pos = adapter.addNewItem(item)
        moveTo(pos)
        return pos
    }

    fun removeItem(item: Model) = adapter.removeItem(item)

    fun removeItemByIndex(index: Int) = adapter.removeItem(index)

    fun updateItemByIndex(index: Int) = adapter.updateItem(index)

    fun updateItem(model: Model) {
        val index = getData().indexOf(model)
        if (index != -1) adapter.updateItem(index, model)
    }

    fun replaceItemByHash(model: Model) = with(getData()) {
        val index = indexOf(model)
        set(index, model)
        updateItem(index, model)
    }

    fun updateItem(index: Int, model: Model) = adapter.notifyItemChanged(index, model)

    fun removeFromToEnd(index: Int) {
        val data = adapter.getData()
        data.subList(index, data.size).clear()
        adapter.notifyDataSetChanged()
    }

    fun getItem(pos: Int) = adapter.getData()[pos]

    fun moveToLast() {
        rec.smoothScrollToPosition(adapter.size)
    }

    private fun moveTo(pos: Int) {
        rec.smoothScrollToPosition(pos)
    }
}