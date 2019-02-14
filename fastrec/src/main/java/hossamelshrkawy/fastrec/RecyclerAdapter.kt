package hossamelshrkawy.fastrec

import android.app.Activity
import android.view.View
import android.view.ViewGroup

/**
 * Created by Hossam Elsharkawy
 * 0201099197556
 *
 *
 * on 27/06/17.
 */

abstract class RecyclerAdapter<Holder : BaseHolder<Model>, Model>(
        context: Activity, private val rowItemId: Int)
    : BaseRecyclerAdapter<Holder, Model>(context) {


    /**********************************************************/

    /*private fun getHolder(itemView: View?): Holder {
        //return kClass.objectInstance!!
        return kClass.primaryConstructor!!.call(itemView)
    }*/

    /*   private fun cre(kClass: KClass<Holder>): Holder {
           return kClass.primaryConstructor!!.call()
       }
       fun function(factory: () -> Holder) {
           val x: Holder = factory()
       }

       fun getKClass(o: Any): KClass<Any> = o.javaClass.kotlin
       inline fun <reified tt : Any> create(): tt {
           return tt::class.primaryConstructor!!.call()
       }*/

    /**********************************************************/

    protected abstract fun getHolder(itemView: View): Holder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return getHolder(getItemView(parent))
    }


    override fun onBindViewHolder(holder: Holder, position: Int) = holder.setView(get(position))

    private fun getItemView(parent: ViewGroup) = inflater.inflate(rowItemId, parent, false)


}
