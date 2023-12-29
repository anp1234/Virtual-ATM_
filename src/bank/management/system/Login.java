/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


/**
 *
 * @author acer
 */
public class Login extends JFrame implements ActionListener {
    JButton login, signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login()
    {
        
        setLayout(null);
        setTitle("AUTOMATED TELLER MACHINE");
        ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image icon2=icon1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon icon3=new ImageIcon(icon2);
        JLabel label=new JLabel(icon3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Onsward",Font.BOLD,40));
        text.setBounds(200, 40, 400, 40);
        add(text);
        
        
        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(100, 150, 150, 40);  
        add(cardno);
        
        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,250,40);
        cardTextField.setFont(new Font("Arial",Font.BOLD,16));
        add(cardTextField);
        
        
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(100, 220, 400, 40);
        add(pin);
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,250,40);
        pinTextField.setFont(new Font("Arial",Font.PLAIN,16));
        add(pinTextField);
        
        
        
        login=new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("CLEAR");
        clear.setBounds(450, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("SIGN UP");
        signup.setBounds(300, 370, 250, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,100);
        
    }
    
    
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
            
        }
        else if (ae.getSource()==login){
            
          
            String scardnumber=cardTextField.getText();
            String spin=pinTextField.getText();
            
            
                
            Conn c=new Conn();
            String query="select * from login where cardnumber='"+scardnumber+"' and pin='"+spin+"'";
            try
            {
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transaction(spin).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
                
            }
            
            catch(Exception e)
            {
                System.out.println(e);
            }
          
        }
        
        else if(ae.getSource()==signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new Login();
    }
    
}
