package br.com.quanto.democonsumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoConsumerApplication

fun main(args: Array<String>) {
    runApplication<DemoConsumerApplication>(*args)
}
