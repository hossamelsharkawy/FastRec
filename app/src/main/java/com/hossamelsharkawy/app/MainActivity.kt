package com.hossamelsharkawy.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hossamelsharkawy.fastrec.header.FastRecHeader
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.header_item.view.*
import kotlinx.android.synthetic.main.item.view.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val data = arrayListOf<Any>().apply {
            add("Cat1")
            add(Image(1, "Url 1"))
            add(Image(1, "Url 2"))
            add(Image(1, "Url 3"))
            add(Image(1, "Url 4"))
            add(Image(1, "Url 1"))
            add(Image(1, "Url 2"))
            add(Image(1, "Url 3"))
            add(Image(1, "Url 4"))

            add("Cat2")
            add(Image(1, "Url 1"))
            add(Image(1, "Url 2"))
            add(Image(1, "Url 3"))
            add(Image(1, "Url 4"))

            add("Cat3")
            add(Image(1, "Url 1"))
            add(Image(1, "Url 2"))
            add(Image(1, "Url 3"))
            add(Image(1, "Url 4"))
        }


        // val map = hashMapOf<String ,ArrayList<Image>>()

        val xx = FastRecHeader.HeaderBuilder<Image>()
            .with(this)
            .attach(rec_)
            .headerId(R.layout.header_item)
            .rowId(R.layout.item)
            .onHeaderView { itemView, model, _ ->
                itemView.txt_headerTitle.text = model
            }
            .onItemView { itemView, model, _ ->
                itemView.txt_title.text = model.url
            }
            .setData(data)
            .build()

            .dataControl


        xx.addNewItem("assadsa")

        xx.updateItem(0,"")

    }

    class Image(val id: Int, val url: String)


}


