package com.privilege.dao.impl;

import com.privilege.dao.PrivilegesDao;
import com.privilege.po.Privileges;
import com.privilege.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class PrivilegesDaoImpl implements PrivilegesDao {
    private QueryRunner queryRunner= C3P0Util.getQueryRunner();
    @Override
    public List<Privileges> getPrivilegeList(int roleid) {
        String sql="select * from \"privileges\" where \"id\" in(SELECT \"privilege_id\" FROM \"roleprivilege\" where \"role_id\"=?)";
        List<Privileges> query=null;
        try {
            query= queryRunner.query(sql, new BeanListHandler<Privileges>(Privileges.class), roleid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public List<Privileges> getALLPrivilegesList() {
        String sql="select *from \"privileges\" ORDER BY \"id\"";
        List<Privileges> list=null;
        try {
            list = queryRunner.query(sql, new BeanListHandler<Privileges>(Privileges.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int deletePrivilegesByRoleid(String[] deleterroleids,int roleid) {
        String sql="delete from \"roleprivilege\" where \"privilege_id\"=? and \"role_id\"="+roleid;
        int update=0;
            try {
                for(int i=0;i<deleterroleids.length;i++){
                    update += queryRunner.update(sql, deleterroleids[i]);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return update;
    }

    @Override
    public int addPrivilegesByRoleid(String[] addroleids ,int roleid) {
        String sql="insert into  \"roleprivilege\" values(?,?)";
        int add=0;
        try {
            for(int i=0;i<addroleids.length;i++){
                add += queryRunner.update(sql, addroleids[i],roleid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return add;
    }

    @Override
    public int addPrivilege(Privileges privilege) {
        String sql="insert into \"privileges\" values(grade_seq.nextval,?,?,?)";
        int rows=0;
        try {
            rows=queryRunner.update(sql,privilege.getName(),privilege.getFnpath(),privilege.getDescription());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public List<Privileges> getPrivilegesList(int roleid) {
        String sql="select *from \"privileges\" where \"id\" not in(SELECT \"privilege_id\" FROM \"roleprivilege\" where \"role_id\"=?)";
        List<Privileges> query=null;
        try {
            query= queryRunner.query(sql, new BeanListHandler<Privileges>(Privileges.class), roleid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
}
