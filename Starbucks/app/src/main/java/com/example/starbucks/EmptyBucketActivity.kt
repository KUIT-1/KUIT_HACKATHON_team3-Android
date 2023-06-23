package com.example.starbucks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.starbucks.databinding.ActivityBucketBinding
import com.example.starbucks.databinding.ActivityEmptyBucketBinding
import com.example.starbucks.databinding.ActivityMainBinding

class EmptyBucketActivity : AppCompatActivity() {
    lateinit var binding:ActivityEmptyBucketBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmptyBucketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bucketBtnBackIv.setOnClickListener{
            finish()
        }
    }







}