package com.hossamelsharkawy.fastrec.header

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import com.hossamelsharkawy.fastrec.core.BaseRecyclerAdapter
import com.hossamelsharkawy.fastrec.core.FastHolder

/**
 * Created by Hossam Elsharkawy
 * on 27/06/17.
 */

class AdapterHeader<Model>(
    context: Activity,
    private val rowItemId: Int,
    private val headerItemId: Int,
    val onSetView: (itemView: View, m: Model, pos: Int) -> Unit,
    val onSetHeaderView: (itemView: View, m: String, pos: Int) -> Unit

) : BaseRecyclerAdapter<FastHolder<Any>, Any>(context) {

    companion object {
        const val TypeHeader = 5
        const val TypeModel = 10
    }

    override fun getItemViewType(position: Int) = if (get(position) is String) {
        TypeHeader
    } else {
        TypeModel
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FastHolder<Any> = when (viewType) {
        TypeHeader -> getHeaderItemHolder(parent)
        else -> getModelItemHolder(parent)
    }

    override fun onBindViewHolder(holder: FastHolder<Any>, p: Int) = holder.setView(get(p), p)

    private fun getHeaderItemHolder(parent: ViewGroup): FastHolder<Any> {
        with(getHeaderView(parent)) {
            return object : FastHolder<Any>(this@with) {
                override fun setView(m: Any, p: Int) {
                    onSetHeaderView.invoke(this@with, m as String, p)
                }
            }
        }
    }

    private fun getModelItemHolder(parent: ViewGroup): FastHolder<Any> {
        with(getItemView(parent)) {
            return object : FastHolder<Any>(this@with) {
                override fun setView(m: Any, p: Int) {
                    onSetView.invoke(this@with, m as Model, p)
                }
            }
        }
    }

    private fun getItemView(parent: ViewGroup) = inflater.inflate(rowItemId, parent, false)

    private fun getHeaderView(parent: ViewGroup) = inflater.inflate(headerItemId, parent, false)
}