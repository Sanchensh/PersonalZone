package com.mrxu.personalzone.service;

import com.mrxu.personalzone.entity.User;

import java.util.List;

public interface UserDAO {
    //登录
    boolean login(String userAccount, String userPwd);
    //得到所有用户信息
    List<User> getAllUser();
    //是否有该用户
    boolean isHasAccount(String userAccount);
    //注册用户
    boolean regUser(User user);
    //删除用户
    boolean deleteUser(String userID);
    //根据用户ID修改用户信息
    boolean updateUser(User user);
    //搜索用户
    List<User> find(String userName,String userID);
}
