/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;




/**
 *
 * @author acer
 */
public class FastCash extends JFrame implements ActionListener{
    
    JButton one,three,five,ten,fifteen,thirty,back;
    String pinnumber;
    
    
    public FastCash(String pin)
    {
        this.pinnumber=pin;
        setLayout(null);
        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        JLabel image=new JLabel(icon);
        image.setBounds(10,10,800,800);
        add(image);
        
        JLabel text=new JLabel("Please select your Fast Cash");
        text.setBounds(200, 200, 200, 30);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        
        
        one=new JButton("1000");
        one.setBounds(100, 250, 150, 30);
        one.addActionListener(this);
        image.add(one);
        
        
        three=new JButton("3000");
        three.setBounds(300, 250, 150, 30);
        three.addActionListener(this);
        image.add(three);
        
        five=new JButton("5000");
        five.setBounds(100,320, 150, 30);
        five.addActionListener(this);
        image.add(five);
        
        ten=new JButton("10000");
        ten.setBounds(300, 320, 150, 30);
        ten.addActionListener(this);
        image.add(ten);
        
        
        fifteen=new JButton("15000");
        fifteen.setBounds(100, 390, 150, 30);
        fifteen.addActionListener(this);
        image.add(fifteen);
        
        thirty=new JButton("30000");
        thirty.setBounds(300, 390, 150, 30);
        thirty.addActionListener(this);
        image.add(thirty);
        
        back=new JButton("Back");
        back.setBounds(300, 460, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        

        
        
        
        
        
        setLocation(300,0);
        setUndecorated(true);
        setTitle("Transaction Page");
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
        else
        {
            String amount=((JButton)ae.getSource()).getText();
            Conn c=new Conn();
            
            try
            {
                ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
                int balance=0;
                while(rs.next())
                {
                    if(rs.getString("type").equals("Deposit"))
                    {
                        balance+=Integer.parseInt( rs.getString("amount"));
                    }
                    else if (rs.getString("type").equals("Withdrawl"))
                    {
                        balance-=Integer.parseInt(rs.getString("amount"));
                        
                    }
                    
                }
                if(Integer.parseInt(amount)>balance )
                {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                    
                }
                else
                {
                
                Date date=new Date();
                String query="insert into bank values ('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully ");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                }
                
                
                
                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }  
    }
    
    
    public static void main(String args[])
    {
        new FastCash("");
        
    }
    
}
