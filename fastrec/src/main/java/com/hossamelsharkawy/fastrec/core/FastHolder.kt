package com.hossamelsharkawy.fastrec.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Hossam Elsharkawy
0201099197556
on 29/07/19.  time :14:13

 */
abstract class FastHolder<Model>(v: View) : RecyclerView.ViewHolder(v) {
    abstract fun setView(m: Model, p: Int)
}