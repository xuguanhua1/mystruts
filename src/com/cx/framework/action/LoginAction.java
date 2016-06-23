package com.cx.framework.action;

import com.cx.entity.User;
import com.cx.service.UserService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cxspace on 16-6-21.
 *
 * Action表示动作类
 *
 * 1.一个servlet对应一个action
 * 2.action负责处理具体的请求
 *
 */
public class LoginAction {

    public Object execute(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException
    {
        return null;
    }


     //对应登录操作的方法
    public Object login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object uri = null;
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
//            //登录失败
//            req.getRequestDispatcher("/login.jsp").forward(req,resp);
       //     uri = req.getRequestDispatcher("/login.jsp");  //返回控制跳转的对象
              uri = "loginFaild"; // loginFaild对应login.jsp

        }else {
              //登录成功，保存数据到session
              req.getSession().setAttribute("userInfo" , userInfo);
//            //到首页
//            resp.sendRedirect(req.getContextPath()+"/index.jsp");
//             uri = "/index.jsp";
               uri = "loginSuccess";  //loginSuccess 对应index.jsp

        }

        return  uri;
    }
}
