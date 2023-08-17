package com.kotlin.kotlinexamples.operator.domain.models

data class EventKey(
    val accountId: String,
    val storeHash: String,
    val resourceType: String,
    val resourceId: String,
) {
    companion object ResourceTypes {
        const val CUSTOMER = "customer"
        const val ORDER = "order"
        const val PRODUCT = "product"
    }
}
