package br.com.quanto.democonsumer

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class Consumer {

    @KafkaListener(id = "myID", topics = ["topic1"])
    fun receive(msg: String) {
        println(msg)
    }
}
