package com.rimi.bms.dao.impl;

import com.rimi.bms.dao.IUserDao;
import com.rimi.bms.entity.User;

import java.sql.*;

/**
 * @author shangzf
 * @date 2019/9/20 17:00
 */
public class UserDaoImpl implements IUserDao {
    @Override
    public User selectByUsername(String username) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // 1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获取数据连接
            conn = DriverManager.getConnection("jdbc:mysql:///bms", "root", "123456");
            // 3.定义sql
            String sql = "SELECT * from user where username = ?";
            // 4.创建执行SQL对象
            pstmt = conn.prepareStatement(sql);
            // 5.设置参数
            pstmt.setString(1, username);
            // 6.执行SQL,获取结果对象
            rs = pstmt.executeQuery();
            // 7.遍历结果集
            while (rs.next()) {
                String username1 = rs.getString("username");
                String password = rs.getString("password");
                // 创建user对象
                User user = new User();
                user.setUsername(username1);
                user.setPassword(password);
                return user;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
