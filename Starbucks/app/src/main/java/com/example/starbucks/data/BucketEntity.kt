package com.example.starbucks.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BucketTable")
data class Bucket(
    val picture: Int,
    val title: String,
    val title_en: String,
    val temperature: String,
    val size: String,
    val cup: String,
    val num: Int,
    val price: Int
    ) {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}
