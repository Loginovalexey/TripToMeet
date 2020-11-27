package ru.triptomeet.model.entity

/**
 * Заказ
 */

data class Offer(
    override var id: Int,
    var title: String,
    var description: String,
    var shortDescription: String,
    var user_Id: Int? = null,
    var price: Int,
    var currencyName: String? = null,
    var cityId: Int? = null,
    var countryCityName: String? = null,
    var mainPictureUrl: String,
    var isActual: Boolean
) : Identifiable()
