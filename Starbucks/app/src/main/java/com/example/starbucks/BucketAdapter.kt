package com.example.starbucks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starbucks.data.Bucket
import com.example.starbucks.databinding.ItemListBucketBinding

class BucketAdapter(private val itemList:ArrayList<Bucket>): RecyclerView.Adapter<BucketAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemListBucketBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(bucketInfo: Bucket){
            val description = bucketInfo.temperature + "|" +bucketInfo.size + "|" + bucketInfo.cup
            val total_price = bucketInfo.price * bucketInfo.num

            binding.itemListBucketNameTv.text = bucketInfo.title
            binding.itemListBucketNameEnTv.text = bucketInfo.title_en
            binding.itemListBucketDescriptionTv.text = description
            binding.itemListBucketPriceTv.text = bucketInfo.price.toString()
            binding.itemListBucketNumTv.text = bucketInfo.num.toString()
            binding.itemListBucketTotalPriceTv.text = total_price.toString()
            binding.itemListBucketIv.setImageResource(bucketInfo.picture)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBucketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BucketAdapter.ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

}