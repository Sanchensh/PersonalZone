package com.mrxu.personalzone.dao;

import com.mrxu.personalzone.entity.User;
import jdk.nashorn.internal.runtime.ECMAException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //登录或者选出所有用户
    List<User> findUser(@Param("userAccount")String userAccount, @Param("userPwd")String userPwd);
    //判断该账号是否存在
    User isHasAccount(@Param("userAccount")String userAccount);
    //新增一个用户
    boolean insertUser(User user);
    //删除一个用户
    boolean deleteUser(@Param("userID")String userID);
    //根据用户的ID查询该用户
    User getUserByID(@Param("userID")String userID);
    //根据用户ID修改用户信息
    boolean updateUser(User user);
    //搜索用户
    List<User> find(@Param("userName")String userName,@Param("userID")String userID);
}
