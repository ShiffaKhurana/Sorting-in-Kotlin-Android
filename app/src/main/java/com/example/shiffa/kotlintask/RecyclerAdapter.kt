package com.example.shiffa.kotlintask

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class RecyclerAdapter( var myList: List<CarModel>) : RecyclerView.Adapter<RecyclerAdapter.ModelHolder>()  {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerAdapter.ModelHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.recycler_item_row, p0, false)
        return ModelHolder(v)

    }

    override fun getItemCount(): Int= myList.size

    override fun onBindViewHolder(p0: RecyclerAdapter.ModelHolder, p1: Int) {
        val modelInfo: CarModel=myList[p1]
        p0.bind(modelInfo)
    }
    class ModelHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        override fun onClick(p0: View?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
        private var mModel: TextView? = null
        private var mYear: TextView? = null
        private var mPrice: TextView? = null
        private var mHorsePower: TextView? = null
        private var mTrailer: TextView? = null
        private var mRearCamera: TextView? = null


        init {
            mModel = itemView.findViewById(R.id.itemModel)
            mYear = itemView.findViewById(R.id.itemYear)
            mPrice = itemView.findViewById(R.id.itemPrice)
            mHorsePower = itemView.findViewById(R.id.itemhp)
            mTrailer = itemView.findViewById(R.id.itemtrailer)
            mRearCamera = itemView.findViewById(R.id.itemRear)
        }

        fun bind(myList: CarModel) {
           mModel?.text = myList.name
            mYear?.text = myList.release_year.toString()
            mPrice?.text = "$" + myList.price.toString()
            mHorsePower?.text = myList.horsepower.toString()+ "hp"
            mTrailer?.text = myList.trailer.toString() + "lbs"
            mRearCamera?.text = myList.rare_camera.toString()
        }

    }

}
//1

