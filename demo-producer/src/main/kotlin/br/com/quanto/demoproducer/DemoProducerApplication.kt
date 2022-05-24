package br.com.quanto.demoproducer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoProducerApplication

fun main(args: Array<String>) {
    runApplication<DemoProducerApplication>(*args)
}
