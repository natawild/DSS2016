/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;


/**
 *
 * @author gil
 */
public class Connect {
    
    private static final String USERNAME = "root";
    private static final String PASSWORD = "nata24fvr";
    private static final String URL = "localhost";
    private static final String SCHEMA = "dss";
    
    /**
     * Only required once
     */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Open a connection to the database. Don't forget to close-it after using it.
     * @return
     * @throws SQLException 
     */
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://"+URL+"/"+SCHEMA+"?user="+USERNAME+"&password="+PASSWORD);
    }
    
}
