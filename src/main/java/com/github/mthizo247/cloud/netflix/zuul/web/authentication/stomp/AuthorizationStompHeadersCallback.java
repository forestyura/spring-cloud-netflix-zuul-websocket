package com.github.mthizo247.cloud.netflix.zuul.web.authentication.stomp;

import com.github.mthizo247.cloud.netflix.zuul.web.socket.WebSocketMessageAccessor;
import com.github.mthizo247.cloud.netflix.zuul.web.socket.WebSocketStompHeadersCallback;
import org.springframework.http.HttpHeaders;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.web.socket.WebSocketSession;

/**
 * @author Yurii Vlasiuk
 * @version 1.0
 * @since 30.05.2018
 */
public class AuthorizationStompHeadersCallback implements WebSocketStompHeadersCallback {

    @Override
    public void applyHeaders(WebSocketSession userAgentSession, WebSocketMessageAccessor accessor, StompHeaders stompHeaders) {
        String authorizationHeader = accessor.getHeader(HttpHeaders.AUTHORIZATION);
        if ((authorizationHeader != null) && (!authorizationHeader.isEmpty())) {
            stompHeaders.add(HttpHeaders.AUTHORIZATION, authorizationHeader);
        }
    }
}
