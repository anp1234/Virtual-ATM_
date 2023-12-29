/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.regex.Pattern;

/**
 *
 * @author acer
 */
public class Deposit extends JFrame implements ActionListener {
    
    JButton back,deposit;
    JTextField amount;
    String pin;
    Date date=new Date();
    
    public Deposit(String pin)
            
    {
        this.pin=pin;
        setLayout(null);
        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        JLabel image=new JLabel(icon);
        image.setBounds(10,10,800,800);
        add(image);
        
        
        JLabel text=new JLabel("Enter the amount you want to deposit");
        text.setBounds(150,230,300,30);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        amount=new JTextField();
        amount.setBounds(150,290,300,30);
        amount.setBackground(Color.WHITE);
        image.add(amount);
        
        
        
        
        
        deposit=new JButton("Deposit");
        deposit.setBounds(350, 390,100, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
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
            new Transaction(pin).setVisible(true);
        }
        
        else if(ae.getSource()==deposit)
        {
            Conn c=new Conn();
            String number=amount.getText();
            String query="insert into bank values ('"+pin+"','"+date+"','"+"Deposit"+"','"+number+"')";
            try
            {
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
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"Rs "+ number +" is sucessfully deposited");
              amount.setText("");
              
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
        new Deposit("");
    }
}
