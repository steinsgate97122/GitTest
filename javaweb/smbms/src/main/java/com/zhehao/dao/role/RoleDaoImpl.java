package com.zhehao.dao.role;

import com.zhehao.dao.BaseDao;
import com.zhehao.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {

    public List<Role> getRoleList() {
        ArrayList<Role> roleList = new ArrayList<Role>();
        Connection connection = BaseDao.getConnection();

        if (connection != null) {
            PreparedStatement preparedStatement = null;
            String sql = "select * from smbms_role";
            Object[] params = {};
            ResultSet resultSet = BaseDao.executeQuery(connection, preparedStatement, sql, params);
            try{
                while (resultSet.next()) {
                    Role role = new Role();
                    role.setId(resultSet.getInt("id"));
                    role.setRoleCode(resultSet.getString("roleCode"));
                    role.setRoleName(resultSet.getString("roleName"));
                    roleList.add(role);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            BaseDao.closeResources(connection, preparedStatement, resultSet);
        }
        return roleList;
    }
}
