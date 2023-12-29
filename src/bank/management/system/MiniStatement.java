/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;





/**
 *
 * @author acer
 */
public class MiniStatement extends JFrame {
    String pinnumber;
    JButton exit;
    
    
    MiniStatement(String pin)
            
    {
       
        this.pinnumber=pin;
        setLayout(null);
        
        
        JLabel text=new JLabel();
        add(text);
        
        JLabel bank=new JLabel("ABC Bank");
        
        bank.setBounds(130, 50, 200, 30);
        bank.setFont(new Font("Raleway",Font.BOLD,20));
        
        add(bank);
        
        
        JLabel card=new JLabel("");
        card.setBounds(50, 150, 400 , 30);
        card.setFont(new Font("Raleway",Font.BOLD,12));
        add(card);
        
        
        JLabel mini=new JLabel("");
        mini.setBounds(50,250,500,130);
//        mini.setFont(new Font("Raleway",Font.BOLD,12));
        
        add(mini);
        
        
     
        
//        exit =new JButton("Exit");
//        exit.setBounds(400, 550, 80, 30);
//        exit.setBackground(Color.black);
//        exit.setForeground(Color.white);
//        add(exit);
        
        
        
        
        try{
        Conn c =new Conn();
        ResultSet rs=c.s.executeQuery("select * from login where pin='"+pinnumber+"'");
        while(rs.next())
        {
            card.setText("Card No: "+rs.getString("cardnumber").substring(0, 4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
        }
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        try{
        Conn c =new Conn();
        ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
        while(rs.next())
        {
            mini.setText(mini.getText()+ "<html>"+ rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
            
        }
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        try
        {
            Conn c=new Conn();
            int balance=0;
            ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
            while(rs.next())
            {
                if(rs.getString("type").equals("Deposit"))
                {balance+=Integer.parseInt(rs.getString("amount"));}
                
                else if (rs.getString("type").equals("Withdrawl"))
                {balance-=Integer.parseInt(rs.getString("amount"));}
            }
            
        String amount=Integer.toString(balance);
        JLabel text2=new JLabel("Your total amount is Rs "+amount);
        text2.setBounds(50,400, 400, 30);
        text2.setFont(new Font("Raleway",Font.BOLD,18));
        
        add(text2);
            
            
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        
        
        
        
        
        
        setLocation(300,0);
//      setUndecorated(true);
        setTitle("Statement Page");
        setSize(500,600);
        setVisible(true);
        
        
    }
    
   
    
    
    public static void main(String args[])
    {
        new MiniStatement("");
        
    }
    
}
