/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import java.sql.*;

/**
 *
 * @author acer
 */
public class Conn{
    Connection c;
    Statement s;
    
    
   public Conn()
   {
       try{
        
           c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Cootpit$7");
           s=c.createStatement();
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
   }

    void executeUpdate(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
