package com.privilege.text;

import com.privilege.po.Privileges;
import com.privilege.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class text {

    public static void main(String[] args) {
        
        QueryRunner queryRunner= C3P0Util.getQueryRunner();
        String sql="select *from \"privileges\" ";
        List<Privileges> query=null;
        try {
            query= queryRunner.query(sql, new BeanListHandler<Privileges>(Privileges.class));
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        System.out.println(query);
        System.out.println(query);
    }

}
