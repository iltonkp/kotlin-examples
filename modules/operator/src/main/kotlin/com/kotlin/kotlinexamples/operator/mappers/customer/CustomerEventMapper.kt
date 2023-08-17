package com.kotlin.kotlinexamples.operator.mappers.customer

import com.kotlin.kotlinexamples.operator.controller.dtos.RequestDto
import com.kotlin.kotlinexamples.operator.domain.models.CustomerData
import com.kotlin.kotlinexamples.operator.domain.models.EventKey
import com.kotlin.kotlinexamples.operator.domain.models.EventValue
import com.kotlin.kotlinexamples.operator.mappers.MapperOperator
import org.springframework.stereotype.Component

@Component
class CustomerEventMapper : MapperOperator<RequestDto, Pair<EventKey, EventValue<CustomerData>>> {
    override fun execute(input: RequestDto): Pair<EventKey, EventValue<CustomerData>> =
        Pair(
            EventKey(
                accountId = input.accountId,
                storeHash = input.producer.removePrefix("stores/"),
                resourceType = EventKey.CUSTOMER,
                resourceId = input.data.get(key = "id").toString()
            ),
            EventValue(
                accountId = input.accountId,
                storeHash = input.producer.removePrefix("stores/"),
                scope = input.scope,
                createdAt = input.createdAt,
                data = CustomerData(
                    id = input.data.get(key = "id").toString()
                )
            )
        )
}