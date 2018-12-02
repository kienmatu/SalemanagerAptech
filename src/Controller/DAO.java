/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author KIENDINH
 */
public class DAO {
     public Connection conn;
    
    protected DAO() {
        try {
            String url = "jdbc:sqlserver://localhost;user=sa;password=123456";
            conn =  DriverManager.getConnection(url);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
