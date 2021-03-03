package cn.itcast.SocketDemo3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");
        System.out.println("username: "+userName+",password: "+passWord);

        HttpSession session = req.getSession();
        String id = session.getId();
        System.out.println("wssessionid:"+id);

        req.getRequestDispatcher("/WEB-INF/jsp/WebSocketChat.jsp").forward(req,resp);
        // WebSocketChat.jsp不允许直接访问放在WEB-INF下 转发进去

    }

}
