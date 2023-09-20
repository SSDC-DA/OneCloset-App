package com.dadada.onecloset.data.mapper

import com.dadada.onecloset.data.model.closet.response.ClosetListResponse
import com.dadada.onecloset.data.model.closet.response.ClothListResponse
import com.dadada.onecloset.data.model.closet.response.ClothRegisterResponse
import com.dadada.onecloset.data.model.closet.response.ClothResponse
import com.dadada.onecloset.domain.model.Closet
import com.dadada.onecloset.domain.model.Cloth

fun ClosetListResponse.toDomain(): List<Closet> {
    return data
}

fun ClothListResponse.toDomain() : List<Cloth> {
    return data
}

fun ClothResponse.toDomain() : Cloth {
    return data
}

fun ClothRegisterResponse.toDomain() : Long {
    return data
}