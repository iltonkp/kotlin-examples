package com.kotlin.kotlinexamples.operator.mappers

import com.kotlin.kotlinexamples.operator.controller.dtos.RequestDto
import com.kotlin.kotlinexamples.operator.domain.models.EventKey
import com.kotlin.kotlinexamples.operator.domain.models.EventValue
import com.kotlin.kotlinexamples.operator.mappers.customer.CustomerEventMapper
import com.kotlin.kotlinexamples.operator.mappers.customer.OrderEventMapper
import org.springframework.stereotype.Component

@Component
class MapperStrategy(
    private val customerEventMapper: CustomerEventMapper,
    private val orderEventMapper: OrderEventMapper
) {
    fun getMapperInstance(scope: String): MapperOperator<RequestDto, Pair<EventKey, EventValue<*>>>  =
        when (scope) {
            "store/customer/created", "store/customer/updated" -> customerEventMapper
            "store/order/created" -> orderEventMapper
            else -> throw Exception("scope dos not exist")
        }
}