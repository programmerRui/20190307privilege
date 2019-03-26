package com.privilege.service;

import com.privilege.po.Roles;

import java.util.List;

public interface RolesService {
    List<Roles> selectRoles();
    int addRoles(String name,String description);

    //查询角色
    List<Roles> getRolesList(int usersid);
    List<Roles> getRoleList(int usersid);
    //更新角色扮演列表
    int deleteRolesByRoleid(String[] deleterroleids,int userid);
    int addRolesByRoleid(String[] addroleids,int userid);
}
