package com.zhehao.dao.user;

import com.mysql.jdbc.StringUtils;
import com.zhehao.dao.BaseDao;
import com.zhehao.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao {

    // 根据userCode，获取该userCode对应的所有用户集合
    public ArrayList<User> getLoginUser(String userCode) {
        ArrayList<User> userList = new ArrayList<User>();
        Connection connection = BaseDao.getConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            String sql = "select * from smbms_user where userCode = ?";
            Object[] params = {userCode};

            ResultSet resultSet = BaseDao.executeQuery(connection, preparedStatement, sql, params);
            try {
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setUserCode(resultSet.getString("userCode"));
                    user.setUserName(resultSet.getString("userName"));
                    user.setUserPassword(resultSet.getString("userPassword"));
                    user.setGender(resultSet.getInt("gender"));
                    user.setBirthday(resultSet.getDate("birthday"));
                    user.setPhone(resultSet.getString("phone"));
                    user.setAddress(resultSet.getString("address"));
                    user.setUserRole(resultSet.getInt("userRole"));
                    user.setCreatedBy(resultSet.getInt("createdBy"));
                    user.setCreationDate(resultSet.getTimestamp("creationDate"));
                    user.setModifyBy(resultSet.getInt("modifyBy"));
                    user.setModifyDate(resultSet.getTimestamp("modifyDate"));
                    userList.add(user);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 释放资源
            BaseDao.closeResources(connection, preparedStatement, resultSet);
        }
        return userList;
    }

    public int changePassword(int id, String password) {
        Connection connection = BaseDao.getConnection();
        int res = 0;
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            String sql = "update smbms_user set userPassword = ? where id = ?";
            Object[] params = {password, id};

            res = BaseDao.executeUpdate(connection, preparedStatement, sql, params);
            // 释放资源
            BaseDao.closeResources(connection, preparedStatement, null);
        }
        return res;
    }

    // 获取用户总数，支持根据userName模糊搜索，支持根据userRole搜索
    public int getUserCount(String userName, int userRole) {
        Connection connection = BaseDao.getConnection();
        int count = -1;

        if (connection != null) {
            PreparedStatement preparedStatement = null;
            // userName和userRole可以为空，需要拼接sql
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select count(1) as count from smbms_user ");
            ArrayList<Object> paramsList = new ArrayList<Object>();

            if (!StringUtils.isNullOrEmpty(userName)) {
                // userName需要模糊搜索
                stringBuilder.append("where userName like ? ");
                paramsList.add("%" + userName + "%");

                if (userRole > 0) {
                    stringBuilder.append("and userRole = ? ");
                    paramsList.add(userRole);
                }
            } else if (userRole > 0) {
                stringBuilder.append("where userRole = ? ");
                paramsList.add(userRole);
            }
            Object[] params = paramsList.toArray();
            String sql = stringBuilder.toString();

            ResultSet resultSet = BaseDao.executeQuery(connection, preparedStatement, sql, params);

            try {
                if (resultSet.next()) {
                    count = resultSet.getInt("count");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            BaseDao.closeResources(connection, preparedStatement, resultSet);
        }
        return count;
    }

    public ArrayList<User> getUserList(String userName, int userRole, int currentNo, int pageSize) {
        Connection connection = BaseDao.getConnection();
        ArrayList<User> userList = new ArrayList<User>();

        if (connection != null) {
            PreparedStatement preparedStatement = null;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select s1.*, s2.roleName from smbms_user s1 left join smbms_role s2 on s1.userRole = s2.id ");
            ArrayList<Object> paramsList = new ArrayList<Object>();

            if (!StringUtils.isNullOrEmpty(userName)) {
                stringBuilder.append("where userName like ? ");
                paramsList.add("%" + userName + "%");
                if (userRole > 0) {
                    stringBuilder.append("and userRole = ? ");
                    paramsList.add(userRole);
                }
            } else if (userRole > 0) {
                stringBuilder.append("where userRole = ? ");
                paramsList.add(userRole);
            }
            // 分页功能
            stringBuilder.append("order by creationDate asc limit ? , ? ");
            int offset = (currentNo - 1) * pageSize;
            paramsList.add(offset);
            paramsList.add(pageSize);

            Object[] params = paramsList.toArray();
            String sql = stringBuilder.toString();

            ResultSet resultSet = BaseDao.executeQuery(connection, preparedStatement, sql, params);

            try {
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setUserCode(resultSet.getString("userCode"));
                    user.setUserName(resultSet.getString("userName"));
                    user.setGender(resultSet.getInt("gender"));
                    user.setBirthday(resultSet.getDate("birthday"));
                    user.setPhone(resultSet.getString("phone"));
                    user.setUserRole(resultSet.getInt("userRole"));
                    user.setUserRoleName(resultSet.getString("roleName"));
                    userList.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            BaseDao.closeResources(connection, preparedStatement, resultSet);
        }
        return userList;
    }

    public int addUser(User user) {
        Connection connection = BaseDao.getConnection();
        int insertRowNum = 0;
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            String sql = "insert into `jdbc`.`smbms_user`(`userCode`, `userName`, `userPassword`, `gender`, " +
                    "`birthday`, `phone`, `address`, `userRole`, `createdBy`, `creationDate`, `modifyBy`, " +
                    "`modifyDate`, `idPicPath`, `workPicPath`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Object[] params = {user.getId(), user.getUserCode(), user.getUserName(), user.getUserPassword(),
                    user.getGender(), user.getBirthday(), user.getPhone(), user.getAddress(), user.getUserRole(),
                    user.getCreatedBy(), user.getCreationDate(), user.getModifyBy(), user.getModifyDate(),
                    user.getIdPicPath(), user.getWorkPicPath()};
            try {
                // 涉及增删改时，开启事务
                connection.setAutoCommit(false);
                insertRowNum = BaseDao.executeUpdate(connection, preparedStatement, sql, params);
                connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResources(connection, preparedStatement, null);
            }
        }
        return insertRowNum;
    }
}
