package com.example.starbucks.`interface`

import com.example.starbucks.dto.Menu
import com.example.starbucks.dto.MenuCategory
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService  {
    @GET("menus/1")
    fun getMenuCategories(): Call<MenuCategory>

    @GET("menus/{menu_categoryId}")
    fun getMenuCategory(@Path("menu_categoryId") menu_categoryId: Int): Call<MenuCategory>

    @GET("menus/detail/{detail_categoryId}")
    fun getMenus(@Path("detail_categoryId") detail_categoryId: Int): Call<Menu>
}