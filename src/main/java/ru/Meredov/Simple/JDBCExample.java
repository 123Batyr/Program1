package ru.Meredov.Simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExample {
    public static void main(String[] args) {
        String dbUrl = "jdbc:postgresql://" + args[0] + ":" + args[1] + "/" + args[2];
        String username = args[3];
        String password = args[4];

        try (Connection conn = DriverManager.getConnection(dbUrl, username, password)) {

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}