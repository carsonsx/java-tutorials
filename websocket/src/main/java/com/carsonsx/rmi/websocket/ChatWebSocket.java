package com.carsonsx.rmi.websocket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *
 * Created by carsonsx on 18/03/2017.
 */
@ServerEndpoint("/websocket")
@Component
public class ChatWebSocket {

    private static Log logger = LogFactory.getLog(ChatWebSocket.class);
    private static CopyOnWriteArraySet<Session> sessions = new CopyOnWriteArraySet<>();
    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        logger.info("new connection: " + session.getId());
        sessions.add(session);
        this.session = session;
        //logger.info("create session: " + session);
    }

    @OnMessage
    public void onMessage(String message) {
        logger.info(message);
        Iterator<Session> iter = sessions.iterator();
        while(iter.hasNext()) {
            Session s = iter.next();
            if (s != session) {
                try {
                    s.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @OnError
    public void onError(Throwable error) {
        error.printStackTrace();
    }

    @OnClose
    public void onClose() {

        logger.info("closed");

    }

}
