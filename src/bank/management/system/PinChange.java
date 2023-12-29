/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;





/**
 *
 * @author acer
 */
public class PinChange extends JFrame implements ActionListener{
    
    JButton confirm,back;
    JTextField pinTextField, repinTextField;
    String pinnumber;
    PinChange(String pin)
            
    {
        this.pinnumber=pin;
        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        JLabel image=new JLabel(icon);
        image.setBounds(10,10,800,800);
        add(image);
        
        
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,20));
        text.setBounds(220, 220, 200, 30);
        image.add(text);
        
        JLabel pintext=new JLabel("New PIN:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway",Font.BOLD,16));
        pintext.setBounds(180, 280, 200, 30);
        image.add(pintext);
        
        pinTextField=new JTextField();
        pinTextField.setBounds(300, 280, 100, 30);
        image.add(pinTextField);
        
        
        
        
        JLabel repintext=new JLabel("Re-type PIN:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Raleway",Font.BOLD,16));
        repintext.setBounds(180, 320, 200, 30);
        image.add(repintext);
        
        
        repinTextField=new JTextField();
        repinTextField.setBounds(300, 320, 100, 30);
        image.add(repinTextField);
        
        
        
        
        confirm=new JButton("Confirm");
        confirm.setBounds(380, 420, 100, 30);
        confirm.addActionListener(this);
        image.add(confirm);
        
        
        back=new JButton("Exit");
        back.setBounds(380, 460, 100, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        
        
        
        
        
        setLocation(300,0);
        setUndecorated(true);
        setTitle("PinChange Page");
        setSize(850,800);
        setVisible(true);
        
    }
    
    
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==back)
        {
            setVisible(false);
            new Transaction("").setVisible(true);
        }
        else if (ae.getSource()==confirm)
        {
            String pinchange=pinTextField.getText();
            String repinchange=repinTextField.getText();
            
            
            
            if(containsString(pinchange)||containsString(repinchange))
            {
                JOptionPane.showMessageDialog(null, "Invalid Input\nMust be 4 digit number.");
            }
            if(Integer.parseInt(pinchange)<1000 ||Integer.parseInt(repinchange)<1000)
            {
                JOptionPane.showMessageDialog(null, "Pin must start with digit 1");
            }
           if(pinchange.length()!=4)
           {
               JOptionPane.showMessageDialog(null, "Pin must be 4 digit long");
           }
           
           else
           {
            
            if(!pinchange.equals(repinchange))
                
            {JOptionPane.showMessageDialog(null, "Pin does not match");
            }

            else if(pinchange.equals(repinchange))
            {
            
               
                Conn c=new Conn();
                String query1="update login set pin='"+pinchange+"' where pin='"+pinnumber+"'";
                String query2="update bank set pin='"+pinchange+"' where pin='"+pinnumber+"'";
                String query3="update signupthree set pinnumber='"+pinchange+"' where pinnumber='"+pinnumber+"'";
try
                {
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null,"Pin Changed Successfully");
                    setVisible(false);
                    new Transaction(pinchange).setVisible(true);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
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
        new PinChange("").setVisible(true);
    }
    
    }

    

