/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;



/**
 *
 * @author acer
 */
public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,married,unmarried,others;
    JDateChooser dateChooser;
    SignupOne()
   {
     setLayout(null);
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000L)+1000L);
        
        JLabel formno=new JLabel("APPLICATION FORM NO: "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,30));
        formno.setBounds(190,20,600,40);
        add(formno);
        
        
        JLabel personalDetails=new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,20));
        personalDetails.setBounds(290,80,400,22);
        add(personalDetails);
        
        
        JLabel name=new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,15));
        name.setBounds(150,150,400,20);
        add(name);
        
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,12));
        nameTextField.setBounds(300,150,400,20);
        add(nameTextField);
        
        
        
        
        
        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,15));
        fname.setBounds(150,200,400,20);
        add(fname);
        
        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,12));
        fnameTextField.setBounds(300,200,400,20);
        add(fnameTextField);
        
        
       
        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,15));
        dob.setBounds(150,250,400,20);
        add(dob);
        
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,250,400,20);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);
        
        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,15));
        gender.setBounds(150,300,400,20);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(300,300,80,20);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(450,300,80,20);
        add(female);
        
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        
       
        
        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,15));
        email.setBounds(150,350,400,20);
        add(email);
        
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,12));
        emailTextField.setBounds(300,350,400,20);
        add(emailTextField);
        
        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,15));
        marital.setBounds(150,400,400,20);
        add(marital);
        
        married=new JRadioButton("Married");
        married.setBounds(300,400,100,20);
        add(married);
        
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(450,400,100,20);
        add(unmarried);
        
        others=new JRadioButton("Others");
        others.setBounds(600,400,100,20);
        add(others);
        
        ButtonGroup maritalGroup=new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(others);
        
        
        
        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,15));
        address.setBounds(150,450,400,20);
        add(address);
        
        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,12));
        addressTextField.setBounds(300,450,400,20);
        add(addressTextField);
        
        
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,15));
        city.setBounds(150,500,400,20);
        add(city);
        
        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,12));
        cityTextField.setBounds(300,500,400,20);
        add(cityTextField);
        
        
        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,15));
        state.setBounds(150,550,400,20);
        add(state);
        
        
        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,12));
        stateTextField.setBounds(300,550,400,20);
        add(stateTextField);
        
        
        JLabel pin=new JLabel("Postal Code:");
        pin.setFont(new Font("Raleway",Font.BOLD,15));
        pin.setBounds(150,600,400,20);
        add(pin);
        
        pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,12));
        pinTextField.setBounds(300,600,400,20);
        add(pinTextField);
        
        next=new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.setBounds(10,600,100,35);
        next.addActionListener(this);
        add(next);
        
        
        
        
        
       
        
        
        
        
        
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(1000,1000);
        setLocation(350,10);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        
        String formno=""+random;
        String name=nameTextField.getText();
        String fname=fnameTextField.getText();
        String dateOfBirth=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected())
        {
            gender="Male";
        }
        else if(female.isSelected())
        {
            gender="Female";
        }
        
        String email=emailTextField.getText();
        String marital=null;
        if(married.isSelected())
       {
           marital="Marrried";
           
        }
        else if(unmarried.isSelected())
        {
            marital="Unmarried";
            
        }
        
        else if(others.isSelected())
        {
            marital="Other";
            
        }
        
        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String pin=pinTextField.getText();
        String state=stateTextField.getText();
        
        
        
        try{
            
            if (name.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Name is Required");
            }
            if (fname.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Father's Name is Required");
            }
            
            if (dateOfBirth.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Date of Birth is Required");
            }
            if (gender.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Gender is Required");
            }
            if (marital.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Marital is Required");
            }
            if (email.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Email is Required");
            }
            if (address.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Address is Required");
            }
            if (city.equals(""))
            {
                JOptionPane.showMessageDialog(null,"City is Required");
            }
            if (state.equals(""))
            {
                JOptionPane.showMessageDialog(null,"State is Required");
            }
            if (pin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Postal Code is Required");
            }
                        
            
            
            
            else{
                Conn c =new Conn();
                
                
                String query;
                query = "insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dateOfBirth+"','"+gender+"','"+marital+"','"+email+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            
        }
        
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        
        
    }
    
    
    
    
    
    
    public static void main(String args[])
    {
        new SignupOne();
        
    }
    
}
