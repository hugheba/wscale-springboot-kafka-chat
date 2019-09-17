package com.naked.cams.chat.websocket

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.event.EventListener
import org.springframework.messaging.simp.SimpMessageSendingOperations
import org.springframework.messaging.simp.stomp.StompHeaderAccessor
import org.springframework.stereotype.Component
import org.springframework.web.socket.messaging.SessionConnectEvent
import org.springframework.web.socket.messaging.SessionDisconnectEvent

@Component
@Slf4j
class WebSocketEventListener {

    @Autowired SimpMessageSendingOperations messagingTemplate

    @EventListener
    void handleSessionConnected(SessionConnectEvent event) {

    }

    @EventListener
    void handleWebSocketConnectionListener(SessionConnectEvent event) {
        log.info("Received a new web socket connection")
    }

    @EventListener
    void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage())
        String username = (String) headerAccessor.getSessionAttributes().get("username")
        if (username) {
            log.info("User Disconnected : ${username}")

        }
    }
}
