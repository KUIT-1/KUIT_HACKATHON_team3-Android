package com.example.starbucks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyMenuAdapter(val itemList: ArrayList<MyMenu>) :
    RecyclerView.Adapter<MyMenuAdapter.MyMenuViewHolder>() {

    //===== [Click 이벤트 구현을 위해 추가된 코드] ==========================
    // OnItemClickListener 인터페이스 선언
    interface OnItemClickListener {
        fun onItemClick(position: Int) {}
    }

    var itemClickListener: OnItemClickListener? = null


    //======================================================================


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyMenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_menu_item, parent, false)

        return MyMenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyMenuViewHolder, position: Int) {
        holder.tv_title.text = itemList[position].title
        holder.tv_description.text = itemList[position].description
        holder.tv_price.text = itemList[position].price.toString()
        holder.tv_temperature.text = itemList[position].temperature
        holder.tv_size.text = itemList[position].size
        holder.tv_cup.text = itemList[position].cup
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }


    inner class MyMenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_title = itemView.findViewById<TextView>(R.id.title)
        val tv_description = itemView.findViewById<TextView>(R.id.description)
        val tv_price = itemView.findViewById<TextView>(R.id.price)
        val tv_temperature = itemView.findViewById<TextView>(R.id.tv_temperature)
        val tv_size = itemView.findViewById<TextView>(R.id.tv_size)
        val tv_cup = itemView.findViewById<TextView>(R.id.tv_cup)

        init {
            itemView.setOnClickListener {
                itemClickListener?.onItemClick(adapterPosition)
            }
        }
    }
}