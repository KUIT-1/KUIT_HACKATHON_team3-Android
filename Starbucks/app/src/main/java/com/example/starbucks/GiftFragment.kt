package com.example.starbucks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.starbucks.databinding.FragmentGiftBinding

class GiftFragment : Fragment() {
    lateinit var binding: FragmentGiftBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGiftBinding.inflate(inflater, container, false)
        return binding.root
    }
}