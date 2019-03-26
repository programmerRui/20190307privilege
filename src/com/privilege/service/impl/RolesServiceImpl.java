package com.privilege.service.impl;

import com.privilege.dao.RolesDao;
import com.privilege.dao.impl.RolesDaoImpl;
import com.privilege.po.Roles;
import com.privilege.service.RolesService;

import java.util.ArrayList;
import java.util.List;

public class RolesServiceImpl implements RolesService {
    private RolesDao rolesDao=new RolesDaoImpl();
    @Override
    public List<Roles> selectRoles() {
        List<Roles> list=new ArrayList<>();
        list=rolesDao.selectRoles();
        return list;
    }

    @Override
    public int addRoles(String name, String description) {
        return rolesDao.addRoles(name,description);
    }


    @Override
    public List<Roles> getRolesList(int usersid) {
        List<Roles> list=rolesDao.getRolesList(usersid);
        return list;
    }

    @Override
    public List<Roles> getRoleList(int usersid) {
        List<Roles> list=rolesDao.getRoleList(usersid);
        return list;
    }

    @Override
    public int deleteRolesByRoleid(String[] deleterroleids, int userid) {
        return rolesDao.deleteRolesByRoleid(deleterroleids,userid);
    }

    @Override
    public int addRolesByRoleid(String[] addroleids, int userid) {
        return rolesDao.addRolesByRoleid(addroleids,userid);
    }
}
