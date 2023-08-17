package com.kotlin.kotlinexamples.operator.controller

import com.kotlin.kotlinexamples.operator.controller.dtos.RequestDto
import com.kotlin.kotlinexamples.operator.domain.models.EventKey
import com.kotlin.kotlinexamples.operator.domain.models.EventValue
import com.kotlin.kotlinexamples.operator.mappers.MapperExecutor
import com.kotlin.kotlinexamples.operator.mappers.MapperStrategy
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/operator")
class OperatorController(
    private val mapperExecutor: MapperExecutor,
   private val mapperStrategy: MapperStrategy
) {

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun post(@RequestBody param: RequestDto): ResponseEntity<Pair<EventKey, EventValue<*>>> {

        val response = mapperExecutor(
            mapperOperator = mapperStrategy.getMapperInstance(param.scope),
            inputDto = param.apply { accountId = "123456" }
        )

        return ResponseEntity.ok(response)
    }
}