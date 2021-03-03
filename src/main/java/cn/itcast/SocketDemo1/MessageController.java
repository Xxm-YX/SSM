package cn.itcast.SocketDemo1;


import cn.itcast.service.impl.WSMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/message")
public class MessageController {

    private Logger logger = LoggerFactory.getLogger(MessageController.class);
    //服务层调用类
    @Autowired
    private WSMessageService wsMessageService;


    //请求入口
    @RequestMapping(value = "/TestWS",method = RequestMethod.GET)
    @ResponseBody
    public String TestWS(@RequestParam(value = "userId",required = true) Long userId,
                         @RequestParam(value = "message",required = true) String message){
        logger.debug("收到发送请求，向用户{}的消息：{}",userId,message);
        if(wsMessageService.sendToAllTerminal(userId,message)){
            return "发送成功";
        }else {
            return "发送失败";
        }
    }
}
