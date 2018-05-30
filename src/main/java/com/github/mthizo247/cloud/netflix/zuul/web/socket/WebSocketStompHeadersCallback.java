package com.github.mthizo247.cloud.netflix.zuul.web.socket;

import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.web.socket.WebSocketSession;

/**
 * @author Yurii Vlasiuk
 * @version 1.0
 * @since 30.05.2018
 */
public interface WebSocketStompHeadersCallback {
    void applyHeaders(WebSocketSession userAgentSession, WebSocketMessageAccessor accessor, StompHeaders stompHeaders);
}
