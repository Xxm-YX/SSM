package cn.itcast.SocketDemo2;

import com.alibaba.fastjson.JSONObject;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 服务器
 */
@ServerEndpoint("/webSocketByTomcat/{username}")
public class WebSocket {
    //保证并发安全，使用static
    private static int onlineCount = 0;
    private static Map<String,WebSocket> clients = new ConcurrentHashMap<>();
    private Session session;
    private String username;

    @OnOpen
    public void onOpen(@PathParam("username") String username,Session session) throws IOException{
        this.username = username;
        this.session = session;

        addOnlineCount();
        clients.put(username, this);
        System.out.println("已连接");
    }

    @OnClose
    public void onClose() throws IOException{
        clients.remove(username);
        subOnlineCount();
    }



    @OnMessage
    public void onMessage(String message) throws IOException{
        JSONObject jsonTo = JSONObject.parseObject(message);
        System.out.println(jsonTo.getString("to")+":"+jsonTo.getString("msg"));

        if(!jsonTo.getString("to").toLowerCase().equals("all")){
            sendMessageTo(jsonTo.getString("msg"),jsonTo.getString("to"));
        }else {
            sendMessageAll(jsonTo.getString("msg"));
        }
    }

    @OnError
    public void onError(Session session, Throwable error){
        error.printStackTrace();
    }

    private void sendMessageAll(String msg) {
        for (WebSocket item : clients.values()) {
            item.session.getAsyncRemote().sendText(msg);
        }
    }

    private void sendMessageTo(String msg, String to) {

        for (WebSocket item : clients.values()) {
            //取出每一个socket
            if(item.username.equals(to)){
                //异步发送
                item.session.getAsyncRemote().sendText(msg);
            }
        }
    }

    public static synchronized Map<String, WebSocket> getClients() {
        return clients;
    }

    public static synchronized void setClients(Map<String, WebSocket> clients) {
        WebSocket.clients = clients;
    }

    private synchronized void addOnlineCount() {
        WebSocket.onlineCount++;
    }
    private synchronized void subOnlineCount() {
        WebSocket.onlineCount--;
    }
}
