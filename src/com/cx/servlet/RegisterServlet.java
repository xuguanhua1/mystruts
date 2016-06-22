package com.cx.servlet;

import com.cx.entity.User;
import com.cx.framework.action.LoginAction;
import com.cx.framework.action.RegisterAction;
import com.cx.service.UserService;

import javax.servlet.RequestDispatcher;
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

        //只有这两行代码不一样

        //创建action对象，调用登陆方法
        RegisterAction registerAction = new RegisterAction();

        Object uri = registerAction.register(request,response);




        //跳转
        if (uri instanceof String)
        {
            response.sendRedirect(request.getContextPath()+uri.toString());
        }else {
            ((RequestDispatcher)uri).forward(request,response);
          }

        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}

