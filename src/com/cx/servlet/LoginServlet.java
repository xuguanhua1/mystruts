package com.cx.servlet;

import com.cx.entity.User;
import com.cx.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cxspace on 16-6-21.
 */
public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求数据
        String uname = req.getParameter("name");
        String pwd = req.getParameter("pwd");

        User user = new User();

        user.setUname(uname);

        user.setPwd(pwd);


        //2.调用Service
        UserService userService = new UserService();
        User userInfo = userService.logion(user);

        //3.跳转

        if (userInfo == null)
        {
            //登录失败
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }else {
            //登录成功，保存数据到session
            req.getSession().setAttribute("userInfo" , userInfo);
            //到首页
            resp.sendRedirect(req.getContextPath()+"/index.jsp");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          doGet(req,resp);
    }
}
