package com.mrxu.personalzone.service.impl;

import com.mrxu.personalzone.dao.UserMapper;
import com.mrxu.personalzone.entity.User;
import com.mrxu.personalzone.service.UserDAO;
import com.mrxu.personalzone.util.FileHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoImpl implements UserDAO {

    @Autowired
    private UserMapper userMapper;
    //登录
    public boolean login(String userAccount, String userPwd) {
        return userMapper.findUser(userAccount,userPwd).size() == 1;
    }
    //得到所有用户
    public List<User> getAllUser() {
        return userMapper.findUser("","");
    }
    //判断该账号是否存在
    public boolean isHasAccount(String userAccount) {
        return userMapper.isHasAccount(userAccount) != null;
    }
    //注册用户
    public boolean regUser(User user) {
        return userMapper.insertUser(user);
    }

    public boolean deleteUser(String userID) {
        //删除用户头像
        User user = userMapper.getUserByID(userID);
        String path = user.getUserPhoto();
        FileHelper fileHelper = new FileHelper();
        fileHelper.deleteFile(path);
        return userMapper.deleteUser(userID);
    }

    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public List<User> find(String userName,String userID) {
        return userMapper.find("%" + userName + "%",userID);
    }
}
