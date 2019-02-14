package hossamelshrkawy.fastrec

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * Created by Hossam Elsharkawy
 * 0201099197556
 *
 *
 * on 27/06/17.
 */

class FastRec<Model>(private var activity: Activity) {

    lateinit var adapter: FastAdapter<Model>
    private lateinit var recyclerView: RecyclerView

    @LayoutRes
    private var rowId: Int = 0

    private var layoutManager: RecyclerView.LayoutManager? = null

    private val defaultLayoutManager get() = LinearLayoutManager(this.activity)


    fun getMLayoutManager() =layoutManager

    /*******************************************/

    fun rec(@IdRes recId: Int) = apply {
        this.recyclerView = activity.findViewById(recId)
        this.recyclerView.layoutManager = getLayoutManager()
    }

    fun rec(rec: RecyclerView) = apply {
        this.recyclerView = rec
        this.recyclerView.layoutManager = getLayoutManager()
    }

    fun rec(rec: View?) = apply {
        this.recyclerView = rec as RecyclerView
        this.recyclerView.layoutManager = getLayoutManager()
    }

    fun onSetView(onSetView: (itemView: View, model: Model, pos: Int) -> Unit) = apply {
        this.adapter = FastAdapter(activity, rowId, onSetView)
        //adapter.setHasStableIds(true)
        this.recyclerView.adapter = this.adapter

    }

    fun onItemClick(vararg value: Int, onItemClick: (v: View, model: Model, pos: Int) -> Unit) = apply {
        this.adapter.onItemClick = onItemClick
        this.adapter.views = value.toList()

    }

    fun data(data: ArrayList<Model>?) = apply {
        if (data != null)
            this.adapter.setData(data)
    }

    fun rowId(@LayoutRes rowId: Int) = apply {
        this.rowId = rowId
    }

    fun horizontal() = apply {
        setLayoutManagerHORIZONTAL()
    }

    fun addClick(vararg views: View) = apply {
        //adapter.onItemClick?.invoke(it)
    }

    /*******************************************/


    fun addNewData(arrayList: ArrayList<Model>) = adapter.addNewData(arrayList)

    fun addNewItem(item: Model): Int {
        val pos = adapter.addNewItem(item)
        moveTo(pos)
        return pos
    }

    fun removeItem(item: Model) = adapter.removeItem(item)

    fun removeItem(index: Int) = adapter.removeItem(index)

    fun updateItem(index: Int) = adapter.updateItem(index)

    fun updateItem(model: Model) {
        val index = getData().indexOf(model)
        if (index != -1) adapter.updateItem(index, model)
    }

    fun replaceItemByHash(model: Model) = with(getData()) {
        val index = indexOf(model)
        set(index,model)
        updateItem(index , model)
    }


    fun updateItem(index: Int, model: Model) = adapter.notifyItemChanged(index, model)


    fun removeFromToEnd(index: Int) {
        val data = adapter.getData()
        data.subList(index, data.size).clear()
        adapter.notifyDataSetChanged()
    }

    fun replaceData(arrayList: ArrayList<Model>) = adapter.replaceData(arrayList)


    fun getData() = adapter.getData()
    fun getItem(pos: Int) = adapter.getData()[pos]

    /*******************************************/


    fun setLayoutManagerHORIZONTAL() {
        layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setLayoutManager(orientation: Int) {
        layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setLayoutManagerGrid(column: Int) {
        layoutManager = GridLayoutManager(activity, column)
    }

    private fun setLayoutManagerGrid(column: Int, orientation: Int) {
        layoutManager = GridLayoutManager(activity, column, orientation, false)
    }


    fun refreshLayout() {
        this.recyclerView.layoutManager = getLayoutManager()
        this.recyclerView.adapter = this.adapter
    }


    private fun getLayoutManager(): RecyclerView.LayoutManager {
        if (this.layoutManager == null) {
            this.layoutManager = defaultLayoutManager
        }
        return this.layoutManager!!
    }


    fun reset() {
        // this.recyclerView = null
        //  this.adapter = null
    }

    fun moveToLast() {
        recyclerView.smoothScrollToPosition(adapter.size)
    }

    private fun moveTo(pos: Int) {
        recyclerView.smoothScrollToPosition(pos)
    }

}