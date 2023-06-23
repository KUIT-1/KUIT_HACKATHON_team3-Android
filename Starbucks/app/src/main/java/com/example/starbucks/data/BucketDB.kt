package com.example.starbucks.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Bucket::class], version = 1)

abstract class BucketDB : RoomDatabase(){
    abstract fun BucketDao() : BucketDao

    companion object{
        private var instance: BucketDB? = null

        @Synchronized
        fun getInstance(context : Context) : BucketDB? {
            if(instance == null){
                synchronized(BucketDB::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BucketDB::class.java,
                        "bucket-database"
                    ).fallbackToDestructiveMigration()
                        .allowMainThreadQueries().build()

                }
            }
            return instance
        }

    }
}