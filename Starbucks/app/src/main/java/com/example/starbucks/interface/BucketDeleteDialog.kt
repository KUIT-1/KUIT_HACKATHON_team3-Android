package com.example.starbucks.`interface`

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.starbucks.data.BucketDB
import com.example.starbucks.databinding.DialogBucketDeleteBinding

class BucketDeleteDialog : DialogFragment() {
    lateinit var binding: DialogBucketDeleteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogBucketDeleteBinding.inflate(inflater, container, false)

        val bucketDB = BucketDB.getInstance(requireContext())!!
        val bucketDao = bucketDB.BucketDao()


        binding.dialogBucketDeleteBtnCancelCv.setOnClickListener {
            dismiss()
        }

        binding.dialogBucketDeleteBtnOkCv.setOnClickListener{
            bucketDao.deleteAllData()
            dismiss()
            requireActivity().finish()
        }




        return binding.root
    }
}