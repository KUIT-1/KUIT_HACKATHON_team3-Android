package com.example.starbucks

import android.R
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.starbucks.databinding.FragmentOrderBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class OrderFragment : Fragment() {
    lateinit var binding: FragmentOrderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderBinding.inflate(inflater, container, false)
        binding.cake.setColorFilter(Color.parseColor("#12B885"))

        // ViewPager2, TabLayout 참조
        val viewPager:ViewPager2 = binding.viewPager
        val tabLayout: TabLayout = binding.tabLayout

        // FragmentStateAdapter 생성
        val viewpagerFragmentAdapter = ViewPagerAdapter(childFragmentManager,lifecycle)

        // ViewPager2의 adapter 설정
        viewPager.adapter = viewpagerFragmentAdapter


        // ###### TabLayout과 ViewPager2를 연결
        // 1. 탭메뉴의 이름을 리스트로 생성해둔다.
        val tabTitles = listOf<String>("전체 메뉴", "나만의 메뉴")

        // 2. TabLayout과 ViewPager2를 연결하고, TabItem의 메뉴명을 설정한다.
        TabLayoutMediator(tabLayout, viewPager, {tab, position -> tab.text = tabTitles[position]}).attach()

        binding.searchBtn.setOnClickListener{
            val mIntent = Intent(requireContext(),MenuSearchActivity::class.java)
//            mIntent.putExtra("title","Sfdsf")
            startActivity(mIntent)
        }

        return binding.root
    }




}