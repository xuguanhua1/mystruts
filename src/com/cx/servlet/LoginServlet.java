package com.cx.servlet;

import com.cx.entity.User;
import com.cx.framework.action.LoginAction;
import com.cx.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//控制器

/**
 * Created by cxspace on 16-6-21.
 */
public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //创建action对象，调用登陆方法
        LoginAction loginAction = new LoginAction();

        Object uri = loginAction.login(req,resp);

        //跳转
        if (uri instanceof String)
        {
            resp.sendRedirect(req.getContextPath()+uri.toString());
        }else {
            ((RequestDispatcher)uri).forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          doGet(req,resp);
    }
}
