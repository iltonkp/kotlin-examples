package com.kotlin.kotlinexamples.operator.domain.models

import java.time.Instant

data class EventValue<T: BaseData>(
    val accountId: String,
    val storeHash: String,
    val scope: String,
    val createdAt: Instant,
    val data: T,
)
