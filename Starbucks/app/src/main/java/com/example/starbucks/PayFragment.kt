package com.example.starbucks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.starbucks.databinding.FragmentPayBinding

class PayFragment : Fragment() {
    lateinit var binding: FragmentPayBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPayBinding.inflate(inflater, container, false)
        return binding.root
    }
}