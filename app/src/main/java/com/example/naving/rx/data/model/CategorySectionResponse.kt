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

data class CategoryItemsWrapper(
    val categories: List<CategorySectionResponse>,
    val products: List<Any>
)

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