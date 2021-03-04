package cn.itcast.SocketDemo3;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint("/WebSocket/chatRoom")
public class WSServer {

    private static final Set<WSServer> connections =
            new CopyOnWriteArraySet<>();//连接的数量
    private static final String GUEST_PREFIX = "Guest";
    private static final AtomicInteger connectionIds = new AtomicInteger(0);
    private Session session;//保存的客户端的session
    private final String nickname;//用户名

    public WSServer() {
        nickname = GUEST_PREFIX + connectionIds.getAndIncrement();
    }

    public void sendMsgToAll(String message) throws IOException{
        for (WSServer eve : connections) {
            eve.session.getBasicRemote().sendText(message);
        }
    }

    @OnOpen//websocket下的session
    public void start(Session session) throws IOException{
        System.out.println(new String("连接建立成功".getBytes(),"UTF-8"));
        this.session = session;
        connections.add(this);
        String message = String.format("* %s %s",nickname,"加入了聊天室");
        sendMsgToAll(message);
    }

    @OnClose
    public void end() throws IOException{
        System.out.println("连接关闭");
        connections.remove(this);
        String message = String.format("* %s %s",nickname,"离开了聊天室");
        sendMsgToAll(message);
        connectionIds.getAndDecrement();
    }

    /**
     * 接受前台发来的消息
     * @param message
     * @throws IOException
     */
    @OnMessage
    public void incoming(String message) throws IOException{
        System.out.println(nickname + "说："+message);
        sendMsgToAll(message);
    }

    @OnError
    public void onError(Throwable t) throws Throwable{
        System.out.println("Chat Error : "+t.toString());
    }
}
