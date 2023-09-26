package com.zhehao.service.role;

import com.zhehao.dao.role.RoleDao;
import com.zhehao.dao.role.RoleDaoImpl;
import com.zhehao.pojo.Role;
import org.junit.Test;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    // 引入Dao
    private RoleDao roleDao;

    public RoleServiceImpl() {
        roleDao = new RoleDaoImpl();
    }

    public List<Role> getRoleList() {
        List<Role> roleList = roleDao.getRoleList();
        return roleList;
    }

    @Test
    public void testGetRoleList() {
        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        System.out.println(roleList);
    }
}
