/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.corent.servlet_crud;

/**
 *
 * @author shrisaiaravind
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbcon {
    private static final String URL = "DB_URL";
    private static final String USER = "root";
    private static final String PASSWORD = "DB_PASSWORD";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}