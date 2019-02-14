package hossamelshrkawy.fastrec

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Hossam Elsharkawy
 * 0201099197556
 *
 *
 * on 30/04/17.
 */

abstract class FastHolder<Model>(v: View) : RecyclerView.ViewHolder(v) {
    abstract fun setView(m: Model, p: Int)
}