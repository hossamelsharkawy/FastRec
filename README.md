

# FastRec
This is an Android project allowing to ‏using RecyclerView in the simplest way possible.


<a href="https://bintray.com/hossamelshrkawy/FastRec/FastRec/0.0.1/link"><img src="https://api.bintray.com/packages/hossamelshrkawy/FastRec/FastRec/images/download.svg?version=0.0.1"/></a>


# Quick start

  ```kotlin
  <code>
 FastRec.Builder<String>(this)
            .rec(rec_)
            .row(R.layout.item)
            .onView { itemView, model, _ ->
                itemView.txt_title.text = model
            }
            .setData(arrayListOf<String>().apply {
                add("1")
                add("2")
                add("5")
            })
            .build()
  </code>
  ```
