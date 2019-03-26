package com.privilege.dao.impl;

import com.privilege.dao.RolesDao;
import com.privilege.po.Roles;
import com.privilege.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class RolesDaoImpl implements RolesDao {
    private QueryRunner queryRunner= C3P0Util.getQueryRunner();
    @Override
    public List<Roles> selectRoles() {
        String sql="select * from \"roles\" ORDER BY \"id\"";
        List<Roles> rolesList=null;
        try {
            rolesList = queryRunner.query(sql, new BeanListHandler<Roles>(Roles.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rolesList;
    }

    @Override
    public int addRoles(String name, String description) {
        String sql="INSERT INTO \"roles\" VALUES(grade_roles.nextval,?,?)";
        int i=0;
        try {
            i=queryRunner.update(sql,name,description);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    @Override
    public List<Roles> getRolesList(int usersid) {
        String sql="select *from \"roles\" where \"id\" in(select \"role_id\" from \"userrole\" where \"user_id\"=?)";
        List<Roles> list=null;
        try {
            list=queryRunner.query(sql,new BeanListHandler<Roles>(Roles.class),usersid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Roles> getRoleList(int usersid) {
        String sql="select *from \"roles\" where \"id\" not in(select \"role_id\" from \"userrole\" where \"user_id\"=?)";
        List<Roles> list=null;
        try {
            list=queryRunner.query(sql,new BeanListHandler<Roles>(Roles.class),usersid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int deleteRolesByRoleid(String[] deleterroleids, int userid) {
        String sql="delete from \"userrole\" where \"role_id\"=? and \"user_id\"="+userid;
        int rows=0;
            try {
                for(int i=0;i<deleterroleids.length;i++){
                rows+=queryRunner.update(sql,deleterroleids[i]);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return rows;
    }

    @Override
    public int addRolesByRoleid(String[] addroleids, int userid) {
        String sql="insert into \"userrole\" values(?,?)";
        int rows=0;
            try {
                for(int i=0;i<addroleids.length;i++){
                rows+=queryRunner.update(sql,userid,addroleids[i]);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return rows;
    }
}
