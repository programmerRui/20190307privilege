package com.privilege.dao;

import com.privilege.po.Roles;

import java.util.List;

public interface RolesDao {
    List<Roles> selectRoles();
    int addRoles(String name,String description);

    //查询角色
    List<Roles> getRolesList(int usersid);
    List<Roles> getRoleList(int usersid);

    //更新角色扮演列表
    int deleteRolesByRoleid(String[] deleterroleids,int userid);
    int addRolesByRoleid(String[] addroleids,int userid);
}
