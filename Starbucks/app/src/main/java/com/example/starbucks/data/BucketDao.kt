package com.example.starbucks.data

import androidx.room.*


@Dao
interface BucketDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bucket:Bucket)

    @Update
    fun update(bucket: Bucket)

    @Delete
    fun delete(bucket: Bucket)

    @Query("SELECT * FROM BucketTable WHERE id = :idx")
    fun getBucket(idx : Int) : Bucket

    @Query("SELECT * FROM BucketTable")
    fun getBucketList() : List<Bucket>
}