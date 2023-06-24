package com.example.starbucks.dto

import com.example.starbucks.Categories
import com.example.starbucks.Menus
import com.google.gson.annotations.SerializedName

//ExampleResponse.kt
data class Menu(
    @SerializedName("id")
    val id: Int,

    @SerializedName("result")
    val name: Array<Menus>,

    @SerializedName("description")
    val description: String

    // @SerializedName으로 일치시켜 주지않을 경우엔 클래스 변수명이 일치해야함
    // @SerializedName()로 변수명을 입치시켜주면 클래스 변수명이 달라도 알아서 매핑
)