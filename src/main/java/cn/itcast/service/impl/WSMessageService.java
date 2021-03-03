package cn.itcast.service.impl;

import cn.itcast.SocketDemo1.WebsocketDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("webSocketMessageService")
public class WSMessageService {

    private Logger logger = LoggerFactory.getLogger(WSMessageService.class);
    //声明websocket连接类
    private WebsocketDemo websocketDemo = new WebsocketDemo();

    /**
     * 调用websocket类给用户下的所有终端发消息
     * @param userId
     * @param message
     * @return
     */
    public Boolean sendToAllTerminal(Long userId,String message){
        logger.debug("向用户{}的消息：{}",userId,message);
        if(websocketDemo.sendMessageToUser(userId,message)){
            return true;
        }else {
            return false;
        }
    }
}
