package com.example.starbucks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.starbucks.databinding.ActivityMainBinding
import com.example.starbucks.databinding.ActivityMenuDetailBinding

class MenuDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityMenuDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuDetailBinding.inflate(layoutInflater)
        binding.backBtn.setOnClickListener({
            val intent = Intent(
                this,
                MainActivity::class.java) //지금 액티비티에서 다른 액티비티로 이동하는 인텐트 설정
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP //인텐트 플래그 설정
            startActivity(intent) //인텐트 이동
        })
        setContentView(binding.root)
    }

}