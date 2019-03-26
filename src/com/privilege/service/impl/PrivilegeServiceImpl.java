package com.privilege.service.impl;

import com.privilege.dao.PrivilegesDao;
import com.privilege.dao.impl.PrivilegesDaoImpl;
import com.privilege.po.Privileges;
import com.privilege.service.PrivilegeService;

import java.util.ArrayList;
import java.util.List;

public class PrivilegeServiceImpl implements PrivilegeService {
    private PrivilegesDao privilegesDao=new PrivilegesDaoImpl();

    @Override
    public List<Privileges> getPrivilegesList(int roleid) {
        List<Privileges> list= new ArrayList<>();
        List<Privileges> privilegesList = privilegesDao.getPrivilegesList(roleid);
        return privilegesList;
    }

    @Override
    public List<Privileges> getPrivilegeList(int roleid) {
        List<Privileges> privilegeList = privilegesDao.getPrivilegeList(roleid);
        return privilegeList;
    }

    @Override
    public List<Privileges> getALLPrivilegeList() {
       List<Privileges> privilegesList=privilegesDao.getALLPrivilegesList();
        return privilegesList;
    }

    @Override
    public int deletePrivilegesByRoleid(String[] deleterroleids, int roleid) {
        return privilegesDao.deletePrivilegesByRoleid(deleterroleids,roleid);
    }

    @Override
    public int addPrivilegesByRoleid(String[] addroleids, int roleid) {
        return privilegesDao.addPrivilegesByRoleid(addroleids,roleid);
    }

    @Override
    public int addPrivilege(Privileges privilege) {
        return privilegesDao.addPrivilege(privilege);
    }
}
