package com.epam.classwork.se08;

import java.sql.*;

public class Example1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:h2:tcp://localhost/~/test";

        try (Connection connection = DriverManager.getConnection(url, "SA", "");
             Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
             PreparedStatement selectDepartmentWithID = connection.prepareStatement("UPDATE UNIVERSITY.DEPARTMENTS SET NAME='?' WHERE ID=?")) {

            selectDepartmentWithID.setString(1, "newName1");
            selectDepartmentWithID.setInt(2, 0);
            selectDepartmentWithID.addBatch();

            selectDepartmentWithID.setString(1, "newName2");
            selectDepartmentWithID.setInt(2, 1);
            selectDepartmentWithID.addBatch();

            int[] ints = selectDepartmentWithID.executeBatch();

            try (ResultSet result = statement.executeQuery("SELECT * FROM UNIVERSITY.DEPARTMENTS")) {
                while (result.next()) {
                    System.out.println(result.getInt("ID"));
                    System.out.println(result.getString("NAME"));

                    if (result.getInt("ID") == 0) {
                        result.updateString("NAME", "testName");
                        result.updateRow();
                    }

                    System.out.println(result.getString("ACRONYM"));
                }
            }

        }
    }
}
