package com.example.starbucks

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starbucks.`interface`.RetrofitService
import com.example.starbucks.databinding.FragmentWholeMenuBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.starbucks.dto.MenuCategory as MenuCategoryDto

class WholeMenuFragment : Fragment() {
    lateinit var binding: FragmentWholeMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWholeMenuBinding.inflate(inflater, container, false)
        val rv_menuCategory = binding.rvMenuCategory
        val itemList = ArrayList<MenuCategory>()
        itemList.add(MenuCategory(0,"NEW"," "))
        itemList.add(MenuCategory(1,"추천","Recommend"))
        itemList.add(MenuCategory(2,"리저브 에스프레소","Reserve Espresso"))
        itemList.add(MenuCategory(2,"리저브 에스프레소","Reserve Espresso"))
        itemList.add(MenuCategory(2,"리저브 에스프레소","Reserve Espresso"))
        itemList.add(MenuCategory(2,"리저브 에스프레소","Reserve Espresso"))
        val wholeMenuAdapter = WholeMenuAdapter(itemList)
        wholeMenuAdapter.notifyDataSetChanged()

        rv_menuCategory.adapter = wholeMenuAdapter
        rv_menuCategory.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        wholeMenuAdapter.itemClickListener = object : WholeMenuAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val item = itemList[position]
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.main_frm, MenuFragment())
                    ?.commit()
            }
        }

        val retrofit = Retrofit.Builder().baseUrl("http://43.201.156.74:9000/")
//        val retrofit = Retrofit.Builder().baseUrl("http://a8bf-118-131-90-139.ngrok-free.app/")
            .addConverterFactory(GsonConverterFactory.create()).build();
        val service = retrofit.create(RetrofitService::class.java);
        service.getMenuCategories().enqueue(object : Callback<MenuCategoryDto> {
            override fun onResponse(call: Call<MenuCategoryDto>, response: Response<MenuCategoryDto>) {
                if(response.isSuccessful){
                    // 정상적으로 통신이 성고된 경우
                    var result: MenuCategoryDto? = response.body()
//                    itemList.clear()
                    if (result != null) {
                        for(category in result.name ){
                            itemList.add(MenuCategory(category.id,category.name,category.description))
                        }
                    }
                    val wholeMenuAdapter = WholeMenuAdapter(itemList)
                    wholeMenuAdapter.notifyDataSetChanged()

                    rv_menuCategory.adapter = wholeMenuAdapter
                    rv_menuCategory.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

                    wholeMenuAdapter.itemClickListener = object : WholeMenuAdapter.OnItemClickListener {
                        override fun onItemClick(position: Int) {
                            val item = itemList[position]
                            val bundle = Bundle()
                            bundle.putString("id", item.id.toString())
                            val menuFragment = MenuFragment() //프래그먼트2 선언
                            menuFragment.arguments = bundle
                            activity?.supportFragmentManager?.beginTransaction()
                                ?.replace(R.id.main_frm, menuFragment)
                                ?.commit()
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

            override fun onFailure(call: Call<MenuCategoryDto>, t: Throwable) {
                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                Log.d("YMC", "onFailure 에러: " + t.message.toString());
                Toast.makeText(context, "엥", Toast.LENGTH_SHORT).show()
            }
        })

        return binding.root
    }
}

