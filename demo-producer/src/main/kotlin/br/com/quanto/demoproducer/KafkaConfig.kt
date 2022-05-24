package br.com.quanto.demoproducer

import br.com.quanto.qtpb.action.notification.NotificationOuterClass.Notification
import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
class KafkaConfig {

    val senderProps = mapOf(
        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to "localhost:9092",
        ProducerConfig.LINGER_MS_CONFIG to 10,
        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to KafkaProtobufSerializer::class.java,
        "schema.registry.url" to "http://localhost:8081"
    )

    @Bean
    fun producerFactory() = DefaultKafkaProducerFactory<String, Notification>(senderProps)

    @Bean
    fun kafkaTemplate(producerFactory: ProducerFactory<String, Notification>) = KafkaTemplate(producerFactory)
}
