package com.naked.cams.chat.kafka

import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Component

@Component
class KafkaListener {
    @Autowired SimpMessagingTemplate template
    @Autowired KafkaTemplate kafkaTemplate
    @Autowired Gson gson


    @StreamListener(target = "message-down")
    void processMessage(Message pushMessage) {
        this.template.convertAndSend("/topic/message-down", pushMessage)
    }

//    @StreamListener(target = "message-up")
//    void sendMessageToKafa(Message message) {
//        this.kafkaTemplate.send("message-down", gson.toJson(message))
//    }
}
