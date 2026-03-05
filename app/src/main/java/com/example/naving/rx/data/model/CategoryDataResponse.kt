package com.example.naving.rx.data.model

import com.google.gson.annotations.SerializedName

data class CategoryDataResponse(
    val categoryId: Int,
    val categoryName: String,
    val categoryNameAr: String,
    val items: CategoryItemsWrapper,
    @SerializedName("is_recommendation")
    val isRecommendation: Boolean,
    @SerializedName("is_talabeyah")
    val isTalabeyah: Boolean,
    val type: String
)