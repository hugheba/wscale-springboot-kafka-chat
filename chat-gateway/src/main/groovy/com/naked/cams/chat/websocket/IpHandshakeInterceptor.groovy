package com.naked.cams.chat.websocket

import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.server.HandshakeInterceptor

class IpHandshakeInterceptor implements HandshakeInterceptor {

    boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String,Object> attributes) {
        attributes.put("ip", request.headers.getFirst("X-FORWARDED-FOR"))
        attributes.put("authToken", request.headers.getFirst("Authorization"))

        true
    }

    void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) { }
}
