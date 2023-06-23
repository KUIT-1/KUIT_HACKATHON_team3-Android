package com.example.starbucks

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starbucks.`interface`.RetrofitService
import com.example.starbucks.databinding.FragmentMyMenuBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MyMenuFragment : Fragment() {
    lateinit var binding: FragmentMyMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyMenuBinding.inflate(inflater, container, false)
        val rv_myMenu = binding.rvMyMenu
        val itemList = ArrayList<MyMenu>()
        itemList.add(MyMenu(0,"카페 모카","Caffe Mocha", 6000, "HOT", "Grande", "매장컵"))
        itemList.add(MyMenu(1,"카페 모카","Caffe Mocha", 6000, "HOT", "Grande", "매장컵"))
        itemList.add(MyMenu(2,"카페 모카","Caffe Mocha", 6000, "HOT", "Grande", "매장컵"))


        val myMenuAdapter = MyMenuAdapter(itemList)
        myMenuAdapter.notifyDataSetChanged()

        rv_myMenu.adapter = myMenuAdapter
        rv_myMenu.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        myMenuAdapter.itemClickListener = object : MyMenuAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val item = itemList[position]
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.main_frm, MenuFragment())
                    ?.commit()
            }
        }

        return binding.root
    }
}