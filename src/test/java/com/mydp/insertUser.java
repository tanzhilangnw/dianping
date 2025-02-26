package com.hmdp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class insertUser {
    public static void main(String[] args) throws Exception {
        // 数据库连接信息
        String url = "jdbc:mysql://localhost:3306/mydp";
        String username = "root";
        String password = "Tzlnb123";

        // 建立数据库连接
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "INSERT INTO tb_user (phone, password, nick_name, icon, create_time, update_time) VALUES (?, ?, ?, ?, NOW(), NOW())";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // 批量插入 1000 个用户
        for (int i = 1; i <= 1000; i++) {
            pstmt.setString(1, String.valueOf(13500000000L + i)); // 生成手机号
            pstmt.setString(2, "password" + i);                  // 生成密码
            pstmt.setString(3, "user_" + i);                     // 生成昵称
            pstmt.setString(4, "");                              // 设置头像为空
            pstmt.addBatch();                                    // 添加到批处理
            if (i % 100 == 0) {                                  // 每 100 条执行一次
                pstmt.executeBatch();
            }
        }
        pstmt.executeBatch(); // 执行剩余的批处理
        pstmt.close();
        conn.close();
        System.out.println("批量插入完成！");
    }
}