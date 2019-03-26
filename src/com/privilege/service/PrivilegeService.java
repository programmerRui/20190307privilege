package com.privilege.service;

import com.privilege.po.Privileges;

import java.util.List;

public interface PrivilegeService {
    //查询权限
    List<Privileges> getPrivilegesList(int roleid);
    List<Privileges> getPrivilegeList(int roleid);
    List<Privileges> getALLPrivilegeList();

    int deletePrivilegesByRoleid(String[] deleterroleids,int roleid);
    int addPrivilegesByRoleid(String[] addroleids,int roleid);
    //添加权限
    int addPrivilege(Privileges privilege);
}
