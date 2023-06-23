package com.example.starbucks

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.starbucks.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    var list_empty = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        binding.mainLoginSignUpButtonCv.setOnClickListener {
            updateBucket(list_empty)
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