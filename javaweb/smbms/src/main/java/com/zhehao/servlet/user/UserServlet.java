package com.zhehao.servlet.user;

import com.mysql.jdbc.StringUtils;
import com.zhehao.pojo.Role;
import com.zhehao.pojo.User;
import com.zhehao.service.role.RoleService;
import com.zhehao.service.role.RoleServiceImpl;
import com.zhehao.service.user.UserService;
import com.zhehao.service.user.UserServiceImpl;
import com.zhehao.util.Constants;

import com.alibaba.fastjson.JSON;
import com.zhehao.util.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // UserServlet绑定了接口/jsp/user.do，请求该接口时设置method参数，根据参数的不同值进行不同处理，实现Servlet复用
        String method = req.getParameter("method");
        if (method != null) {
            if (method.equals("savepwd")) {
                pwdModify(req, resp);
            } else if (method.equals("pwdmodify")) {
                pwdAuthentication(req, resp);
            } else if (method.equals("query")) {
                // 用户管理页面
                queryUser(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void pwdModify(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 从req中获取修改后的密码
        String password = req.getParameter("newPassword");
        // 从Session中获取当前用户信息
        User user = (User) req.getSession().getAttribute(Constants.USER_SESSION);

        // 输入合法性校验
        if (user != null && !StringUtils.isNullOrEmpty(password)) {
            // Service层修改密码
            UserServiceImpl userService = new UserServiceImpl();
            boolean flag = userService.changePassword(user.getId(), password);
            if (flag) {
                // 修改成功，退出登录，移除Constants.USER_SESSION
                req.setAttribute("message", "修改成功");
                req.getSession().removeAttribute(Constants.USER_SESSION);
            } else {
                req.setAttribute("message", "修改失败");
            }
        }
        // 重定向回密码修改页
        resp.sendRedirect(req.getContextPath() + "/jsp/pwdmodify.jsp");
    }

    public void pwdAuthentication(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 旧密码验证，不需要查库，旧密码信息可以直接查Session，验证正确性
        Object user = req.getSession().getAttribute(Constants.USER_SESSION);
        String oldPassword = req.getParameter("oldpassword");

        // 根据pwdmodify.js中的ajax代码，需要返回一个形如{result:true}的结果数据，这里先构造Map然后转json
        HashMap<String, String> resultMap = new HashMap<String, String>();

        if (user == null) {
            // Session过期
            resultMap.put("result", "sessionerror");
        } else if (StringUtils.isNullOrEmpty(oldPassword)) {
            // 旧密码输入为空
            resultMap.put("result", "error");
        } else {
            if (oldPassword.equals(((User) user).getUserPassword())) {
                // 输入正确
                resultMap.put("result", "true");
            } else {
                // 输入错误
                resultMap.put("result", "false");
            }
        }

        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(JSON.toJSONString(resultMap));
        writer.close();
    }

    public void queryUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取前端传的参数，来源userlist.jsp
        String queryNameInput = req.getParameter("queryname");
        String queryUserRoleInput = req.getParameter("queryUserRole");
        String pageIndexInput = req.getParameter("pageIndex");

        // 处理前端获取的参数，设置默认值
        String queryName = "";
        int queryUserRole = 0;
        int pageIndex = 1;
        int pageSize = 5;  // 这个可以写在配置文件里面

        if (!StringUtils.isNullOrEmpty(queryNameInput)) {
            queryName = queryNameInput;
        }
        if (!StringUtils.isNullOrEmpty(queryUserRoleInput)) {
            queryUserRole = Integer.parseInt(queryUserRoleInput);
        }
        if (!StringUtils.isNullOrEmpty(pageIndexInput)) {
            pageIndex = Integer.parseInt(pageIndexInput);
        }

        // 获取用户总数
        UserServiceImpl userService = new UserServiceImpl();
        int totalCount = userService.getUserCount(queryName, queryUserRole);

        // 根据用户总数换算页码参数
        PageSupport pageSupport = new PageSupport();
        pageSupport.setPageSize(pageSize);
        pageSupport.setCurrentPageNo(pageIndex);
        pageSupport.setTotalCount(totalCount);
        int totalPageCount = pageSupport.getTotalPageCount();
        // 校验当前页码的合法性
        if (pageIndex < 1) {
            pageIndex = 1;
        } else if (pageIndex > totalPageCount) {
            pageIndex = totalPageCount;
        }

        // 获取用户列表，角色列表
        ArrayList<User> userList = userService.getUserList(queryName, queryUserRole, pageIndex, pageSize);
        RoleService roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();

        // 将相关数据返回给前端
        req.setAttribute("userList", userList);
        req.setAttribute("roleList", roleList);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("currentPageNo", pageIndex);
        req.setAttribute("totalPageCount", totalPageCount);
        req.setAttribute("queryUserName", queryName);
        req.setAttribute("queryUserRole", queryUserRole);

        req.getRequestDispatcher("/jsp/userlist.jsp").forward(req, resp);
    }

    public void addUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // 获取前端传的参数，来源useradd.jsp
        String userCode = req.getParameter("userCode");
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String userRole = req.getParameter("userRole");

        User user = new User();
        user.setUserCode(userCode);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setGender(Integer.parseInt(gender));
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setPhone(phone);
        user.setAddress(address);
        user.setUserRole(Integer.parseInt(userRole));
        user.setCreationDate(new Date());
        user.setCreatedBy(((User) req.getSession().getAttribute(Constants.USER_SESSION)).getId());

        UserService userService = new UserServiceImpl();
        if (userService.addUser(user)) {
            resp.sendRedirect(req.getContextPath() + "/jsp/user.do?method=query");
        } else {
            req.getRequestDispatcher("/jsp/useradd.jsp").forward(req, resp);
        }
    }
}
