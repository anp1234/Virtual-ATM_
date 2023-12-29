/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;




/**
 *
 * @author acer
 */
public class Transaction extends JFrame implements ActionListener{
    
    JButton deposit,fastcash,enquiry,pinchange,exit,ministatement,withdrawl,back;
    String pin;
    
    public Transaction(String pin)
    {
        this.pin=pin;
        setLayout(null);
        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        JLabel image=new JLabel(icon);
        image.setBounds(10,10,800,800);
        add(image);
        
        JLabel text=new JLabel("Please select your transaction");
        text.setBounds(200, 200, 200, 30);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        
        
        deposit=new JButton("Deposit");
        deposit.setBounds(100, 250, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(300, 250, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setBounds(100,320, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        pinchange=new JButton("Pin Change");
        pinchange.setBounds(300, 320, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        
        enquiry=new JButton("Balance Enquiry");
        enquiry.setBounds(100, 390, 150, 30);
        enquiry.addActionListener(this);
        image.add(enquiry);
        
        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(300, 390, 150, 30);
        ministatement.addActionListener(this);
        
        image.add(ministatement);
        
        exit=new JButton("Exit");
        exit.setBounds(300, 460, 150, 30);
        exit.addActionListener(this);
        image.add(exit);
        
        back=new JButton("Back");
        back.setBounds(100, 460, 150, 30);
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
        
        if(ae.getSource()==exit)
        {
            System.exit(0);
            
        }
        else if(ae.getSource()==deposit)
        {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }
        
         else if(ae.getSource()==withdrawl)
        {
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }
        
         else if(ae.getSource()==fastcash)
        {
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }
          else if(ae.getSource()==pinchange)
        {
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }
         else if(ae.getSource()==back)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
         else if(ae.getSource()==enquiry)
        {
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }
        else if(ae.getSource()==ministatement)
        {
            
            new MiniStatement(pin).setVisible(true);
        }
    }
    
    
    public static void main(String args[])
    {
        new Transaction("");
        
    }
    
}
