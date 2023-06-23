package com.example.starbucks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starbucks.data.Bucket
import com.example.starbucks.data.BucketDB
import com.example.starbucks.data.BucketDao
import com.example.starbucks.databinding.ActivityBucketBinding
import com.example.starbucks.databinding.ActivityMainBinding

class BucketActivity : AppCompatActivity() {
    var bucketAdapter: BucketAdapter? = null
    lateinit var binding: ActivityBucketBinding
    var bucketList = ArrayList<Bucket>()

    override fun onResume() {
        super.onResume()
        bucketAdapter!!.notifyDataSetChanged()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDummyData()

        binding = ActivityBucketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bucketBtnBackIv.setOnClickListener {
            finish()
        }

        bucketAdapter = BucketAdapter((bucketList))
        binding.bucketItemListRv.adapter = bucketAdapter
        binding.bucketItemListRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


    }

    private fun initDummyData() {
        val bucketDao = BucketDB.getInstance(this)!!.BucketDao()
        val bucketarray = bucketDao.getBucketList()
        bucketList.addAll(bucketarray)
        bucketAdapter?.notifyDataSetChanged()
    }

}