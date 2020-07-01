package com.hossamelsharkawy.fastrec.header

import android.app.Activity
import android.view.View
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.hossamelsharkawy.fastrec.core.BaseBuilder
import com.hossamelsharkawy.fastrec.core.DataControl

/**
 * Created by Hossam Elsharkawy
on 27/06/17.
 */

class FastRecHeader {

    lateinit var dataControl: DataControl<Any>
    var rec: RecyclerView? = null
    private var adapter: AdapterHeader<Any>? = null

    fun reset() {
        //dataControl = null
        adapter = null
        rec = null
    }

    class HeaderBuilder<Model> : BaseBuilder<Model>() {

        fun with(act: Activity) = apply {
            this.act = act
        }

        fun attach(rec: RecyclerView) = apply {
            this.rec = rec
        }

        fun rowId(@LayoutRes rowId: Int) = apply {
            this.rowId = rowId
        }

        fun onItemView(onSetView: (itemView: View, model: Model, pos: Int) -> Unit) = apply {
            this.onSetView = onSetView
        }

        private var data: ArrayList<Any>? = null


        private lateinit var onSetHeaderView: (itemView: View, m: String, pos: Int) -> Unit

        fun setData(data: ArrayList<Any>) = apply {
            this.data = data
        }

        @LayoutRes
        private var headerId: Int = 0

        fun headerId(@LayoutRes headerId: Int) = apply {
            this.headerId = headerId
        }

        fun onHeaderView(onSetHeaderView: (itemView: View, model: String, pos: Int) -> Unit) = apply {
            this.onSetHeaderView = onSetHeaderView
        }


        fun build() = FastRecHeader().apply {

            val adapter =
                AdapterHeader(act!!, rowId, headerId, onSetView, onSetHeaderView)

            if (data != null) {
                adapter.setData(data!!)
            }

            this@apply.rec = this@HeaderBuilder.rec
            this@apply.rec!!.adapter = adapter

            if (rec!!.layoutManager == null) {
                rec!!.layoutManager = defaultLayoutManager
            }

            dataControl = DataControl(rec!!, adapter)
        }
    }


}
