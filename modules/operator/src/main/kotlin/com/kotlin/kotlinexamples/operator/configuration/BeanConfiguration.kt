package com.kotlin.kotlinexamples.operator.configuration

import com.kotlin.kotlinexamples.operator.mappers.MapperExecutorImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {

    @Bean
    fun mapperExecutor() = MapperExecutorImpl()
}