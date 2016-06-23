package com.cx.framework.action;

import com.cx.bean.ActionMapping;
import com.cx.bean.ActionMappingManager;
import com.cx.bean.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by cxspace on 16-6-23.
 * 核心控制器
 *
 * 处理所有请求
 * 1.拦截所有*.action的请求(在web.xml文件中配置)
 * 2.请求
 *    http://localhost:8080/mystruts/login.action
 *    http://localhost:8080/mystruts/register.action
 *
 *
 * 作用：使项目只有着一个servlet
 *
 */

public class ActionServlet extends HttpServlet{

    private ActionMappingManager actionMappingManager;

    //只执行一次
    @Override
    public void init() throws ServletException {

        System.out.println("启动异常");
        actionMappingManager = new ActionMappingManager();
        System.out.println("启动无异常");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求uri,得到请求路径名称[login]
        String uri = req.getRequestURI();

        //得到login

        String actionName = uri.substring(uri.lastIndexOf("/")+1,uri.indexOf(".action"));



        //2.根据路径名称，读取配置文件，得到类全名[com.cx.framework.action.LoginAction]
        //当前请求的处理方法[method="login"]

        ActionMapping actionMapping = actionMappingManager.getActionMapping(actionName);
        String className = actionMapping.getClassName();
        String method = actionMapping.getMethod();

        //3.反射，创建对象，调用方法，获取方法返回的标记

         try {
             Class<?> clazz = Class.forName(className);
             Object obj = clazz.newInstance();
             //通过接口拿到参数类型
             Method m = clazz.getDeclaredMethod(method, HttpServletRequest.class , HttpServletResponse.class);
             //拿到跳转标记

             String returnFlag = (String) m.invoke(obj , req , resp);

             Result result = actionMapping.getResults().get(returnFlag);

             String type = result.getType();

             String page = result.getPage();

             if ("redirect".equals(type)){
                 resp.sendRedirect(req.getContextPath()+page);

             }else {
                 req.getRequestDispatcher(page).forward(req,resp);
             }

         }catch (Exception e){
             throw new RuntimeException("反射类无法找到异常",e);
         }

        //4.拿到标记去，读取配置文件，得到对应页面

        //跳转

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         doGet(req,resp);
    }



}
