package com.epam.classwork.se08.pools.pool1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try (ConnectionPool pool = preparePool();
             Connection con = pool.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM STUDENTS")) {
            while (rs.next()) {
                System.out.println(rs.getInt("ID")
                        + " " + rs.getString("NAME")
                        + " " + rs.getInt("AGE"));
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static ConnectionPool preparePool() throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        pool.setDriverClassName("org.gjt.mm.mysql.Driver");
        pool.setUrl("jdbc:mysql://127.0.0.1/test");
        pool.setUsername("root");
        pool.setPassword("123456");
        pool.setConnectionNumber(5);
        pool.initConnections();
        return pool;
    }
}

