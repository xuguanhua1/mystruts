package com.cx.dao;

import com.cx.entity.User;

/**
 * Created by cxspace on 16-6-21.
 */
public class UserDao {
    //模拟登录
    public User login(User user)
    {
        if ("cxspace".equals(user.getUname()) && "123456".equals(user.getPwd()))
        {
            //登录成功

            return user;
        }

        //登录失败
        return null;

    }

    //模拟注册
    public void register(User user){
        System.out.println("注册用户："+user.getUname());
    }

}
