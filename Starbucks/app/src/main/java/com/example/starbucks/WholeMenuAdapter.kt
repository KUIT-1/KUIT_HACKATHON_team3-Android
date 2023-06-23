package com.example.starbucks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WholeMenuAdapter(val itemList: ArrayList<MenuCategory>) :
    RecyclerView.Adapter<WholeMenuAdapter.WholeMenuViewHolder>() {

    //===== [Click 이벤트 구현을 위해 추가된 코드] ==========================
    // OnItemClickListener 인터페이스 선언
    interface OnItemClickListener {
        fun onItemClick(position: Int) {}
    }

    var itemClickListener: OnItemClickListener? = null


    //======================================================================


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WholeMenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_category_item, parent, false)

        return WholeMenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: WholeMenuViewHolder, position: Int) {
        holder.tv_title.text = itemList[position].title
        holder.tv_description.text = itemList[position].description
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }


    inner class WholeMenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_title = itemView.findViewById<TextView>(R.id.title)
        val tv_description = itemView.findViewById<TextView>(R.id.description)

        init {
            itemView.setOnClickListener {
                itemClickListener?.onItemClick(adapterPosition)
            }
        }
    }
}