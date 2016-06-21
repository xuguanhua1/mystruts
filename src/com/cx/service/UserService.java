package com.cx.service;

import com.cx.dao.UserDao;
import com.cx.entity.User;

/**
 * Created by cxspace on 16-6-21.
 */
public class UserService {

    private UserDao ud = new UserDao();

    //模拟登录
    public User logion(User user)
    {
        return ud.login(user);
    }

    //模拟注册

    public void register(User user)
    {
        ud.register(user);
    }
}
