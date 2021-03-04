<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ChatRoom</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script>
        var ws;
        var ws_url = "ws://localhost:8080/WebSocket/chatRoom"

        $(function () {
            wsConnect();
            $("#send").click(function () {
                sendMessage();
            })
        })

        function wsConnect() {
            if ('WebSocket' in window) {
                ws = new WebSocket(ws_url); // 连接成功 回调函数生成一个ws对象(websocket连接)
            } else if ('MozWebSocket' in window) {
                ws = new MozWebSocket(ws_url);
            } else {
                console.log('Error: WebSocket is not supported by this browser.');
                return;
            }

            // 都是回调函数
            ws.onopen = function () {
                console.log('Info: WebSocket connection opened.');
            };

            ws.onclose = function () {
                console.log('Info: WebSocket closed.');
            };

            ws.onmessage = function (message) {  // message是从后台传过来的
                console.log(message.data);
                $("#chat_content").append("<p>"+message.data+"</p>");
            };
        }
        function sendMessage() {
            var sendMsg = $("#msg").val();
            ws.send(sendMsg);
            $("#msg").val("");
        }

    </script>
</head>
<body>
<div style="width:610px;border:1px solid #000">
    <h1 align="center">Welcome to ChatRoom</h1>
    <div id="chat_content" style="margin: 2px; width: 600px; height: 400px;border:1px solid #000;">
    </div>
    <input id="msg" placeholder="输入消息..." style="margin: 2px; width: 300px;"><button id="send">发送消息</button>
</div>
</body>
</html>
