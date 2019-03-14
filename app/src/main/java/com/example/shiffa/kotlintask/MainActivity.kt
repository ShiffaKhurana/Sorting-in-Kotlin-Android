package com.example.shiffa.kotlintask

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {


    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: RecyclerAdapter
    var list_of_items = arrayOf("Model Name","Release Year", "Price") //Properties to sort list
    var myList= mutableListOf <CarModel>() // Mutable list of data class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set LinearLayout to recycler view
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        // use deafult spinner to show drop-down list for sorting the data and set array adapter to it.
        spinner.setOnItemSelectedListener(this)
        val array_adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list_of_items)
        array_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner?.adapter=array_adapter

       // Add relevant data in this list
        myList.add(CarModel("TRIM: Denali",2019 ,38995.00, 252,1500, "HD Rear Vision Camera"))
        myList.add(CarModel("ACADIA FWD SLT-1",2018, 30195.00,195, 6001, "Provides the driver of a view of the scene"))
        myList.add(CarModel("CANYON DENAL",2017,44490.00, 308 ,7000, "Provides the driver of a view of the scene"))
        myList.add(CarModel("Hummer H2",2009,67450.00, 393,4000, "It comes with rearview camera"))
        myList.add(CarModel("Pontiac GTO", 2007, 34000.00, 400, 4500, "It comes with rearview camera"))

        // set above list to recycler view
        adapter = RecyclerAdapter(myList)
        recyclerView.adapter = adapter

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

        // Take another list to perform sorting
        var newList= listOf<CarModel>()
        //use "when" statement to sort according to the property seleted form the drop-down
       when (p2) {
          0 -> newList=myList.sortedWith(compareBy(CarModel::name))
            1 ->newList=myList.sortedWith(compareBy(CarModel::release_year))
            2 ->newList=myList.sortedWith(compareBy(CarModel::price))
            }

    // now set new list to the below recycler view adapter
     adapter = RecyclerAdapter(newList)
     recyclerView.adapter = adapter
        }
    }

// set properties according to your choice in the data class
data class CarModel(
    var name: String,
    var release_year: Int,
    var price: Double,
    var horsepower: Int,
    var trailer: Int,
    var rare_camera: String
)
