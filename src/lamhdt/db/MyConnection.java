/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamhdt.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;





/**
 *
 * @author HL
 */
public class MyConnection implements Serializable{
   public static Connection getConnection() throws Exception{
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1120;databaseName=dbTayDuKy","sa","112000");
       return conn;
   }
    
}
