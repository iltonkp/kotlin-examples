package com.kotlin.kotlinexamples.operator.mappers.customer

import com.kotlin.kotlinexamples.operator.controller.dtos.RequestDto
import com.kotlin.kotlinexamples.operator.domain.models.EventKey
import com.kotlin.kotlinexamples.operator.domain.models.EventValue
import com.kotlin.kotlinexamples.operator.domain.models.OrderData
import com.kotlin.kotlinexamples.operator.mappers.MapperOperator
import org.springframework.stereotype.Component

@Component
class OrderEventMapper : MapperOperator<RequestDto, Pair<EventKey, EventValue<OrderData>>> {
    override fun execute(input: RequestDto): Pair<EventKey, EventValue<OrderData>> =
        Pair(
            EventKey(
                accountId = input.accountId,
                storeHash = input.producer.removePrefix("stores/"),
                resourceType = EventKey.ORDER,
                resourceId = input.data.get(key = "id").toString()
            ),
            EventValue(
                accountId = input.accountId,
                storeHash = input.producer.removePrefix("stores/"),
                scope = input.scope,
                createdAt = input.createdAt,
                data = OrderData(
                    id = input.data.get(key = "id").toString()
                )
            )
        )
}