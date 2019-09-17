package com.naked.cams.chat.controllers

import com.naked.cams.chat.kafka.Message
import com.naked.cams.chat.service.KafkaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {

    @Autowired KafkaService kafkaService

    @GetMapping("/")
    String index() {
        return "index"
    }

    @MessageMapping("message-up")
    void incoming(SimpMessageHeaderAccessor ha, Message message) {
        final topic = "message-up"
        Map<String,String> attr = [
                "ip", ha.sessionAttributes.get("ip"),
                "authToken", ha.sessionAttributes.get("authToken")
        ]

        kafkaService.sendMessage("message-up", topic, message, attr)
    }

}
