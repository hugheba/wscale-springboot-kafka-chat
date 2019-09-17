package com.naked.cams.chat.service

import org.springframework.stereotype.Service

@Service
class ClientDetailsService {

    static String getClientIp(request) {

        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }
}
