package com.example.starbucks

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starbucks.databinding.FragmentMenuBinding



class MenuFragment : Fragment() {
    lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)

        val rv_menu = binding.rvMenu
        val itemList = ArrayList<Menu>()
        itemList.add(Menu(0,"아이스 카페 아메리카노","Iced Caffe Americano", 4500))
        itemList.add(Menu(0,"아이스 카페 아메리카노","Iced Caffe Americano", 4500))
        itemList.add(Menu(0,"아이스 카페 아메리카노","Iced Caffe Americano", 4500))
        itemList.add(Menu(0,"아이스 카페 아메리카노","Iced Caffe Americano", 4500))

        val menuAdapter = MenuAdapter(itemList)
        menuAdapter.notifyDataSetChanged()

        rv_menu.adapter = menuAdapter
        rv_menu.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        menuAdapter.itemClickListener = object : MenuAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val item = itemList[position]
//                activity?.supportFragmentManager?.beginTransaction()
//                    ?.replace(R.id.main_frm, MenuFragment())
//                    ?.commit()
                val mIntent = Intent(requireContext(),MenuDetailActivity::class.java)
//            mIntent.putExtra("title","Sfdsf")
                startActivity(mIntent)
            }
        }

        binding.backBtn.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.main_frm, OrderFragment())
                ?.commit()
        }

        binding.searchBtn.setOnClickListener{
            val mIntent = Intent(requireContext(),MenuSearchActivity::class.java)
//            mIntent.putExtra("title","Sfdsf")
            startActivity(mIntent)
        }
        return binding.root
    }
}