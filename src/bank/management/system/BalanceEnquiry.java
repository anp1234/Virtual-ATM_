/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.*;




/**
 *
 * @author acer
 */
public class BalanceEnquiry  extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;
    
    
    BalanceEnquiry(String pin)
    {
        this.pinnumber=pin;
        setLayout(null);
        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        JLabel image=new JLabel(icon);
        image.setBounds(10,10,800,800);
        add(image);
        
        Conn c=new Conn();
        String query="select *from bank where pin='"+pinnumber+"'";
        int balance=0;
        
        try
        {
            
        
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                if(rs.getString("type").equals("Deposit"))
                {balance+=Integer.parseInt(rs.getString("amount"));}
                
                else if (rs.getString("type").equals("Withdrawl"))
                {balance-=Integer.parseInt(rs.getString("amount"));}
            }
            
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        String amount=Integer.toString(balance);
        JLabel text=new JLabel("Your total amount is Rs "+amount);
        text.setBounds(100, 220, 400, 30);
        text.setFont(new Font("Raleway",Font.BOLD,18));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        
        
        
        
        
        back=new JButton("Back");
        back.setBounds(350, 450, 100, 30);
        back.addActionListener(this);
        image.add(back);
        
        setLocation(300,0);
//      setUndecorated(true);
        setTitle("BalanceEnquiry Page");
        setSize(850,800);
        setVisible(true);
        
        
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    
    
    
    
    public static void main(String args[])
    {
        new BalanceEnquiry("");
    }
    
}
