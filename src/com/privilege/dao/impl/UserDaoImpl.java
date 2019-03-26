package com.privilege.dao.impl;

import com.privilege.dao.UserDao;
import com.privilege.po.Roles;
import com.privilege.po.User;
import com.privilege.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;

public class UserDaoImpl implements UserDao {
    //获取C3P0的操作对象
    private QueryRunner queryRunner= C3P0Util.getQueryRunner();
    @Override
    public int login(String username,String password)  {
        String sql="select count(*) from \"users\" where \"username\"=? and \"password\"=?";
        String count="";
        try {
            count = queryRunner.query(sql,new ScalarHandler(1),username,password).toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(count);
    }

    @Override
    public int register(User user) {
        String sql="insert into \"users\" values(grade_users.nextval,?,?,?)";
        int i=0;
        try {
            i=queryRunner.update(sql,user.getUsername(),user.getPassword(),user.getNickname());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List<User> checkusername(String username) {
        String sql="select * from \"users\" where \"username\"=?";
        List<User> user=null;
        try {
            user=queryRunner.query(sql, new BeanListHandler<User>(User.class),username );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int updatepwd(String username, String password) {
        String sql="UPDATE \"users\" set \"password\"=? where \"username\"=?";
        int i=0;
        try {
            i=queryRunner.update(sql,password,username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List<User> selectUser() {
        String sql="select * from \"users\"";
        List<User> list=null;
        try {
            list=queryRunner.query(sql,new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



}
