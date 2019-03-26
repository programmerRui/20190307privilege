package com.privilege.service;

import com.privilege.po.Roles;
import com.privilege.po.User;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public interface UserService {
    //登录
    int login(String username,String password) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException;
    //注册
    int register(User user);
    //检查用户名是否存在
    List<User> checkusername(String username);
    //修改密码
    int updatepwd(String username,String password);
    //查询用户
    List<User> selectUser();


}
