package com.example.starbucks

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starbucks.`interface`.RetrofitService
import com.example.starbucks.databinding.FragmentMenuBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MenuFragment : Fragment() {
    lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        var id = arguments?.getString("id")

        val rv_menu = binding.rvMenu
        val itemList = ArrayList<Menu>()
        itemList.add(Menu(0,"아이스 카페 아메리카노","Iced Caffe Americano", 4500))
        itemList.add(Menu(0,"아이스 카페 아메리카노","Iced Caffe Americano", 4500))
        itemList.add(Menu(0,"아이스 카페 아메리카노","Iced Caffe Americano", 4500))
        itemList.add(Menu(0,"아이스 카페 아메리카노","Iced Caffe Americano", 4500))
        itemList.add(Menu(0,"아이스 카페 아메리카노","Iced Caffe Americano", 4500))
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

        binding.ivBagBtn.setOnClickListener{
            updateBucket(true);
        }

        val retrofit = Retrofit.Builder().baseUrl("http://43.201.156.74:9000/")
//        val retrofit = Retrofit.Builder().baseUrl("http://a8bf-118-131-90-139.ngrok-free.app/")
            .addConverterFactory(GsonConverterFactory.create()).build();
        val service = retrofit.create(RetrofitService::class.java);
        if (id != null) {
            Log.d("YMC", id)
            service.getMenus(id.toInt()).enqueue(object :
                Callback<com.example.starbucks.dto.Menu> {
                override fun onResponse(call: Call<com.example.starbucks.dto.Menu>, response: Response<com.example.starbucks.dto.Menu>) {
                    if(response.isSuccessful){
                        // 정상적으로 통신이 성고된 경우
                        var result: com.example.starbucks.dto.Menu? = response.body()
                        itemList.clear()
                        if (result != null) {
                            for(menu in result.name ){
                                itemList.add(Menu(menu.detail_cate_id,menu.name,menu.description, menu.price))
                            }
                        }
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
    //                    itemList.add(MenuCategory(result.name,"리저브 에스프레소","Reserve Espresso"))
                        Log.d("YMC", "onResponse 성공: " + response.body());
    //                    Toast.makeText(context, "${response.body()}", Toast.LENGTH_SHORT).show()
                    }else{
                        // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                        Log.d("YMC", "onResponse 실패")
                        Toast.makeText(context, "엥", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<com.example.starbucks.dto.Menu>, t: Throwable) {
                    // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                    Log.d("YMC", "onFailure 에러: " + t.message.toString());
                    Toast.makeText(context, "엥", Toast.LENGTH_SHORT).show()
                }
            })
        }
        
        return binding.root
    }

    fun updateBucket(state:Boolean){
        if(state){
            val intent = Intent(activity, EmptyBucketActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(activity, BucketActivity::class.java)
            startActivity(intent)
        }
    }
}