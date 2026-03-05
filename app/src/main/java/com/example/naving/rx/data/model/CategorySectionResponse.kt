package com.example.naving.rx.data.model

import com.google.gson.annotations.SerializedName

data class CategorySectionResponse(
    @SerializedName("children_type")
    val childrenType: String,
    val id: Int,
    val image: String,
    @SerializedName("name_ar")
    val nameAr: String,
    @SerializedName("name_en")
    val nameEn: String
)


