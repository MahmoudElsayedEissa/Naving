package com.example.naving.rx.data.mappers

import com.example.naving.rx.data.model.CategorySectionResponse
import com.example.naving.rx.domain.model.CategorySectionDomainModel

object CategoryDomainDataMapper {
    fun map(categotySection: CategorySectionResponse) = with(categotySection) {
        CategorySectionDomainModel(
            childrenType, id, image, nameAr, nameEn
        )
    }
}