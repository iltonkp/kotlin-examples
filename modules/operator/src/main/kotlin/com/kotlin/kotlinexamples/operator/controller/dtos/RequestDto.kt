package com.kotlin.kotlinexamples.operator.controller.dtos

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.Instant

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class RequestDto(
    val scope: String,
    val storeId: String,
    val data: Map<String, Any?>,
    val hash: String,
    val createdAt: Instant,
    val producer: String
) {
    lateinit var accountId: String
}
