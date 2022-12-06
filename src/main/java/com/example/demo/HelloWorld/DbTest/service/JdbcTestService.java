package com.example.demo.HelloWorld.DbTest.service;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author maxiao
 */
@Component
@Getter
@Setter
@Log4j2
public class JdbcTestService {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.81.128:3306/JPAtest?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    static final String USER = "root";
    static final String PASS = "123456";

    public List<String> getQuerySql(String sql) {

        Connection conn = null;
        Statement stmt = null;

        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            log.debug("连接数据库");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            List<String> result = new ArrayList<>();
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String sex = rs.getString("sex");

                result.add("id=" + id + ",name=" + name + ",sex=" + sex);
            }

            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
            log.debug("关闭数据库连接");

            return result;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
