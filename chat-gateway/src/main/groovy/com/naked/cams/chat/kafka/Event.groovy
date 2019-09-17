package com.naked.cams.chat.kafka

class Event {
    Date timestamp = new Date().getTime()
    EventType eventType
    String clientIp
    String authToken
    String source
    String destination
    Object message
}
