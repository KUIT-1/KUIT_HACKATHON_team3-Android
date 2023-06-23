package com.example.starbucks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(val itemList: ArrayList<Menu>) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    //===== [Click 이벤트 구현을 위해 추가된 코드] ==========================
    // OnItemClickListener 인터페이스 선언
    interface OnItemClickListener {
        fun onItemClick(position: Int) {}
    }

    var itemClickListener: OnItemClickListener? = null


    //======================================================================


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false)

        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.tv_title.text = itemList[position].title
        holder.tv_description.text = itemList[position].description
        holder.tv_price.text = itemList[position].price.toString()
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }


    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_title = itemView.findViewById<TextView>(R.id.title)
        val tv_description = itemView.findViewById<TextView>(R.id.description)
        val tv_price = itemView.findViewById<TextView>(R.id.price)

        init {
            itemView.setOnClickListener {
                itemClickListener?.onItemClick(adapterPosition)
            }
        }
    }
}