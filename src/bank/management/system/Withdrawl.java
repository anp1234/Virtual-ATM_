/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import static bank.management.system.Deposit.containsString;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

/**
 *
 * @author acer
 */
public class Withdrawl extends JFrame implements ActionListener {
    
    JButton back,withdrawl;
    JTextField amount;
    String pinnumber;
    Date date=new Date();
    
    public Withdrawl(String pin)
            
    {
        this.pinnumber=pin;
        setLayout(null);
        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        JLabel image=new JLabel(icon);
        image.setBounds(10,10,800,800);
        add(image);
        
        
        JLabel text=new JLabel("Enter the amount you want to withdraw");
        text.setBounds(150,230,320,30);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        amount=new JTextField();
        amount.setBounds(150,290,300,30);
        amount.setBackground(Color.WHITE);
        image.add(amount);
        
        
        
        withdrawl=new JButton("Withdraw");
        withdrawl.setBounds(350, 390,100, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        back=new JButton("Back");
        back.setBounds(350, 430,100, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        
        
        
        
        
        
        
        
        
        
        setLocation(300,0);
//        setUndecorated(true);
        setTitle("Transaction Page");
        setSize(850,800);
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==back)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        
        else if(ae.getSource()==withdrawl)
        {
            Conn c=new Conn();
            String number=amount.getText();
            
            try
            {
              if (number.equals(""))
              {
                  JOptionPane.showMessageDialog(null,"Please enter the amount");
              }
              if (number.equals(""))
              {
                  JOptionPane.showMessageDialog(null,"Please enter the amount");
              }
              if(containsString(number))
              {
                  JOptionPane.showMessageDialog(null,"Invalid Input");
              }
              if(Integer.parseInt(number)<0)
              {
                  JOptionPane.showMessageDialog(null,"Invalid Input");
              }
              if(Integer.parseInt(number)==0)
              {
                  JOptionPane.showMessageDialog(null,"Amount must be greater than 0");
                  
              }
              
              
              else{
                  
             ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
                int balance=0;
                while(rs.next())
                {
                    if(rs.getString("type").equals("Deposit"))
                    {
                        balance+=Integer.parseInt( rs.getString("amount"));
                    }
                    else
                    {
                        balance-=Integer.parseInt(rs.getString("amount"));
                        
                    }
              
              }
               if(Integer.parseInt(number)>balance)
                   
               {
                   JOptionPane.showMessageDialog(null,"Insufficient Balance");
               }
               else
               {
                   
                   c.s.executeUpdate("insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')");
                   JOptionPane.showMessageDialog(null,"Rs "+number+ " is debitted successfully.");
                   amount.setText("");
                   
               }
               
               {
                   
               }
            }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
        }
    }
     public static boolean containsString(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }
    
    
    public static void main(String args[])
    {
        new Withdrawl("");
    }
}
