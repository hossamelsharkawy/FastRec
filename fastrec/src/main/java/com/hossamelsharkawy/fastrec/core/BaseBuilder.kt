package com.hossamelsharkawy.fastrec.core

import android.app.Activity
import android.view.View
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hossamelsharkawy.fastrec.horizontal

/**
 * Created by Hossam Elsharkawy
0201099197556
on 30/07/19.  time :11:24

 */

abstract class BaseBuilder<Model> {

    internal lateinit var rec: RecyclerView
    internal var act: Activity? = null

    internal val defaultLayoutManager get() = LinearLayoutManager(this.act)

    internal lateinit var onSetView: (itemView: View, m: Model, pos: Int) -> Unit

    @LayoutRes
    internal var rowId: Int = 0


    fun horizontal() = apply { rec.horizontal() }

}