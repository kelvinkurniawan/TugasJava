/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import java.sql.DriverManager;

/**
* This class is used to create connection to database
*/
public class DBConnection {
    private Connection con;
   /**
   * This method is used to create connection to database
   */
    public Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr?zeroDateTimeBehavior=convertToNull", "root", "");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return con;
    }
}
