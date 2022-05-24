package br.com.quanto.demoproducer

import br.com.quanto.qtpb.action.notification.NotificationOuterClass.Configuration
import br.com.quanto.qtpb.action.notification.NotificationOuterClass.Notification
import com.google.protobuf.ByteString
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@Controller
class APIProducer(
    @Autowired val producer: KafkaTemplate<String, Notification>
) {

    @GetMapping(value = ["/"])
    fun produce(): ResponseEntity<String> {
        val c = Configuration
            .newBuilder()
            .setSecret("123456")
            .setUrl("http://localhost:8089/webhook")
//            .putHeaders("Content-Type", "text/plain")
//            .putHeaders("X-my-header", "some-custom-header-value")

        val payload = """
            {
                "custom":"payload"
            }
        """.trimIndent()

        val n = Notification
            .newBuilder()
            .setReceiverId("24e55476-e504-4a0c-a970-fa3f8c00d52a")
            .setScope("SCOPE_TEST")
            .setConfiguration(c)
            .setPayload(ByteString.copyFrom(payload.toByteArray()))
            .build()
        producer.send("platform.action.notify", n)

        return ResponseEntity.ok("ok! producer")
    }

    @GetMapping("/database")
    fun produceDatabaseWebhook(): ResponseEntity<Any> {
        val payload = """
            {
                "custom":"database build"
            }
        """.trimIndent()

        val n = Notification
            .newBuilder()
            .setReceiverId("5c510ed6-3774-4c86-8000-8d8d3f117f3e")
            .setScope("SCOPE_USER")
            .setPayload(ByteString.copyFrom(payload.toByteArray()))
            .build()
        producer.send("platform.action.notify", n)

        return ResponseEntity.ok("ok! producer")
    }

    @PostMapping(value = ["/webhook"])
    fun webhook(
        @RequestHeader(name = "Content-type", required = false) contentType: String?,
        @RequestHeader(name = "X-my-header", required = false) myHeader: String?,
        @RequestHeader(name = "sign", required = false) sign: String?,
        @RequestBody body: WebhookBody
//        @RequestBody body: String
    ): ResponseEntity<Any> {
        println("Chegou o Webhook")
        println("BODY=$body, TYPE=$contentType, CUSTOM=$myHeader, SIGN=$sign")
        return ResponseEntity.ok().build()
    }
}

data class WebhookBody(
    val custom: String
)
