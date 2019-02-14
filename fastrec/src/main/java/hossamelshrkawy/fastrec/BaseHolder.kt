package hossamelshrkawy.fastrec

import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Hossam Elsharkawy
 * 0201099197556
 *
 *
 * on 30/04/17.
 */

abstract class BaseHolder<Model>(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    protected fun click(@IdRes vararg ids: Int) {
        for (id in ids) {
            click(id)
        }
    }

     fun click(vararg views: View) {
        for (view in views) {
            click(view)
        }
    }

    protected fun <T : View> bind(id: Int): T {
        return itemView.findViewById(id)
    }

     fun click(id: Int) {
        itemView.findViewById<View>(id).setOnClickListener(this)
    }

     fun click(view: View) {
        view.setOnClickListener(this)
    }




    abstract fun setView(m: Model)

}
