package com.github.mthizo247.cloud.netflix.zuul.web.authentication.stomp;

import com.github.mthizo247.cloud.netflix.zuul.web.socket.WebSocketMessageAccessor;
import com.github.mthizo247.cloud.netflix.zuul.web.socket.WebSocketStompHeadersCallback;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;

/**
 * @author Yurii Vlasiuk
 * @version 1.0
 * @since 30.05.2018
 */
public class CompositeStompHeadersCallback implements WebSocketStompHeadersCallback {

    private List<WebSocketStompHeadersCallback> stompHeadersCallbacks;

    public CompositeStompHeadersCallback(final List<WebSocketStompHeadersCallback> stompHeadersCallbacks) {
        this.stompHeadersCallbacks = stompHeadersCallbacks;
    }

    @Override
    public void applyHeaders(WebSocketSession userAgentSession, WebSocketMessageAccessor accessor, StompHeaders stompHeaders) {
        if ((stompHeadersCallbacks != null) && (!stompHeadersCallbacks.isEmpty())) {
            for(WebSocketStompHeadersCallback callback: stompHeadersCallbacks) {
                callback.applyHeaders(userAgentSession, accessor, stompHeaders);
            }
        }
    }
}
