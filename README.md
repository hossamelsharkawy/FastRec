
# FastRec
This is an Android project allowing to ‏using RecyclerView in the simplest way possible.

<a href="https://bintray.com/hossamelshrkawy/FastRec/FastRec/0.0.1/link"><img src="https://api.bintray.com/packages/hossamelshrkawy/FastRec/FastRec/images/download.svg?version=0.0.1"/></a>

# Installation
**Add the dependencies to your gradle file:**

```javascript
 dependencies { 
   implementation 'com.hossamelsharkawy:fastrec:0.0.1'
 }
```

# Quick start

Implement **FastRec** in an android activity  :

  ```kotlin
  FastRec.Builder<String>(this)
            .rec(R.id.recyclerView)  //  pass recyclerView or recyclerID
            .row(R.layout.item)
            .onView { itemView, model, pos ->
                itemView.txt_title.text = model
            }
            .setData(arrayListOf<String>().apply {
                add("1")
                add("2")
                add("5")
            })
            .build()
  ```


**Add RecyclerView in activity xml  :** 
 ```xml
 <androidx.recyclerview.widget.RecyclerView  
	android:id="@+id/recyclerView" 
	android:layout_width="match_parent"  
	android:layout_height="match_parent"  
  />
  ```


**itemView.xml**
 ```xml
<?xml version="1.0" encoding="utf-8"?>  
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"  
				  android:orientation="vertical"  
				  android:layout_width="match_parent"  
				  android:layout_height="70dp"> 
	  <TextView
				  android:id="@+id/txt_title"  
			      android:layout_width="wrap_content"  
		  	      android:layout_height="wrap_content"/>  
</LinearLayout>
  ```


# DataControl 
Use the DataControl object to handle common operations on your data.

**init dataControl object :** 
  ```kotlin
 val dataControl = FastRec.Builder<String>(this)
            .rec(R.id.recyclerView) 
            .row(R.layout.item)
            .onView { itemView, model, pos ->
                itemView.txt_title.text = model
            }
            .build().dataControl // return dataControl
  ```
  
 **handel dummy data  :** 
 ```kotlin 
 fun getDummyData() = arrayListOf<String>().apply {  
	for (i in 0..5) {  
	     add("$i")  
	 }  
}
 ```

**Usage**
****  
 ```kotlin 
// Set data by reference
dataControl.setData(getDummyData())

//Set data by copy
dataControl.replaceData(getDummyData())

//Add Item 
dataControl.addNewItem("5")


//Remove Item
dataControl.removeItem("5") //remove item by index
dataControl.removeItem(0)  // remove item by value
 ```
 




**Other method :**  

|      Method          |     Job                                     
|----------------      |----------------  
|setData(array: ArrayList<Model>)       |set data by copy          
|replaceData(array: ArrayList<Model>) |set data by reference 
|addNewItem(item: Model): Int |insert new item 
|updateItem(index: Int, model: Model) |update item by index and object 
|updateItem(item: Model) |update item by object 
|updateItem(index: Int) |update item by index 
|replaceItemByHash(model: Model) |replace item item by HashMap 
|removeItem(item: Model) |remove item by object 
|removeItem(index: Int) |remove item by index 
|removeFromToEnd(index: Int) |remove item to end 
|getItem(index: Int) |return item by inedx 
|moveToLast(index: Int) | 
|moveTo(index: Int) | 



# RecyclerView Extension 
**Usage**
```kotlin 
myRecyclerView.horizontal() 
or 
myRecyclerView.setGrid(3, RecyclerView.HORIZONTAL)
 ```


**Other method :**  

|      Method                                      
|---------------
vertical()        |      
horizontal()        |   
setGrid(column: Int, orientation: Int) |
setGrid(column: Int)  | 
setLayoutManager(orientation: Int)     |   


