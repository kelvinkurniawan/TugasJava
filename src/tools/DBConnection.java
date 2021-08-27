/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author kelvi
 */
public class DBConnection {
    private Connection con;

    public Connection getConnection() {

        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr?zeroDateTimeBehavior=convertToNull", "root", "");
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr_db?zeroDateTimeBehavior=convertToNull", "root", "");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return con;
    }
}
