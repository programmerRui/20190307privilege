package com.privilege.service.impl;

import com.privilege.dao.UserDao;
import com.privilege.dao.impl.UserDaoImpl;
import com.privilege.po.Roles;
import com.privilege.po.User;
import com.privilege.service.UserService;
import com.privilege.utils.MD5Util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    @Override
    public int login(String username, String password) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
        //MD5加密
        password= MD5Util.MD5Encoding(password);
        //调用dao层login的方法
        int rows=userDao.login(username,password);
        return rows;

    }

    @Override
    public int register(User user) {
        //MD5加密
        int i=0;
        try {
            user.setPassword(MD5Util.MD5Encoding(user.getPassword()))  ;
            i=userDao.register(user);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List<User> checkusername(String username) {

        List<User>user=userDao.checkusername(username);
        return user;
    }

    @Override
    public int updatepwd(String username, String password) {
        int i=0;
        try {
             i=userDao.updatepwd(username,MD5Util.MD5Encoding(password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List<User> selectUser() {
        List<User> list=userDao.selectUser();
        return list;
    }



}
