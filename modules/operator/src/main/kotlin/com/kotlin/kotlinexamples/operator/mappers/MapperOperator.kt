package com.kotlin.kotlinexamples.operator.mappers

interface MapperOperator<in Input, out Output> {
    fun execute(input: Input): Output
}

interface MapperExecutor {
    operator fun <InputDto, Output> invoke(
        mapperOperator: MapperOperator<InputDto, Output>,
        inputDto: InputDto,
    ): Output
}

class MapperExecutorImpl : MapperExecutor {
    override fun <InputDto,  Output> invoke(
        mapperOperator: MapperOperator<InputDto, Output>,
        inputDto: InputDto,
    ): Output = mapperOperator.execute(inputDto)
}