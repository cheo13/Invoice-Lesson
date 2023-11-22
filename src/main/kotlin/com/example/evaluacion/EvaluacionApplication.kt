package com.example.evaluacion

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.flyway.FlywayConfigurationCustomizer
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class EvaluacionApplication

fun main(args: Array<String>) {
	runApplication<EvaluacionApplication>(*args)

}
