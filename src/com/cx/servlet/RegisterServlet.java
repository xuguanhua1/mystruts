package com.cx.servlet;

import com.cx.entity.User;
import com.cx.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cxspace on 16-6-21.
 */

public class RegisterServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //1.获取请求数据
            String uname = request.getParameter("name");

            System.out.println(uname);

            String pwd = request.getParameter("pwd");

            User user = new User();
            user.setUname(uname);
            user.setPwd(pwd);

            //2.调用service
            UserService userService = new UserService();
            userService.register(user);

            //3.跳转
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}

