package com.mashup.alcoholfree.data.model.measure

import com.mashup.alcoholfree.data.remote.response.DrinkResponse
import com.mashup.alcoholfree.domain.model.Drink

data class DrinkDataModel(
    val drinkType: String,
    val glasses: Int,
) {
    companion object {
        operator fun invoke(response: DrinkResponse): DrinkDataModel {
            return DrinkDataModel(
                drinkType = response.drinkType,
                glasses = response.glasses,
            )
        }

        fun toDomainModel(data: DrinkDataModel): Drink {
            return Drink(
                drinkType = data.drinkType,
                glasses = data.glasses,
            )
        }
    }
}