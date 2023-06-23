package com.example.starbucks.`interface`

import com.example.starbucks.dto.MenuCategory
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService  {
    @GET("menus/1")
    fun getMenuCategories(): Call<MenuCategory>

    @GET("menuCategory")
    fun getMenuCategory(@Query("menu_categoryId") menu_categoryId: Int): Call<MenuCategory>
}