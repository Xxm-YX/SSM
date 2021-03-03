package cn.itcast.SocketDemo2;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value="webSocketByTomcat/serviceToClient")
public class ServiceClientByTomcatController {

    private WebSocket webSocket = new WebSocket();

    public void sendMsg(HttpServletRequest request, HttpServletResponse response) throws IOException{
        JSONObject json = new JSONObject();
        json.put("to",request.getSession().getId());
        json.put("msg","欢迎连接WebSocket!!");
        webSocket.onMessage(json.toJSONString());
    }
}
