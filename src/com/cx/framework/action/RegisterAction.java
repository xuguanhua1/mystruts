package com.cx.framework.action;

import com.cx.entity.User;
import com.cx.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cxspace on 16-6-21.
 */
public class RegisterAction {

    public Object register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object uri = null;

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
   //   request.getRequestDispatcher("/login.jsp").forward(request,response);

      //  uri = request.getRequestDispatcher("/login.jsp");

        return "registerSuccess"; //返回注册成功的标记    在配置文件中 registerSuccess = /login.jsp

    }
}
