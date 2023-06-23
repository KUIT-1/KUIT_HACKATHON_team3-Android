package com.example.starbucks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.starbucks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, WebtoonFragment())
            .commitAllowingStateLoss()


        binding.mainBnv.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.webtoonFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, WebtoonFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.recommendFinishFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, RecommendFinishFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.bestChallengeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, BestChallengeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.myFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, MyFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.moreFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, MoreFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }

        binding.mainBnv.itemIconTintList = null
    }
}