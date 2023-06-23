package com.example.starbucks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.starbucks.data.Bucket
import com.example.starbucks.data.BucketDB
import com.example.starbucks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bucketDB = BucketDB.getInstance(this)!!
        initDummy((bucketDB))

        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()


        binding.mainBnv.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.webtoonFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.recommendFinishFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, PayFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.bestChallengeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, OrderFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.myFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, GiftFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.moreFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, OtherFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }

        binding.mainBnv.itemIconTintList = null
    }


    fun initDummy(bucketDB: BucketDB){
        val bucketDao = bucketDB.BucketDao()
        bucketDao.insert(
            Bucket(
                R.drawable.ic_launcher_background,
                "라이트 키위 라임 브렌디드",
                "Light Kiwi Lime Blended",
                "ICED",
                "Tall",
                "매장컵",
                1,
                6300
                )
        )

    }
}