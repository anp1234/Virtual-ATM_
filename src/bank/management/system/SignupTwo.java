/*/*
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
public class SignupTwo extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField,identity,pan;
    JButton next;
    JRadioButton male,female,married,unmarried,others,sno,syes,eyes,eno;
    JDateChooser dateChooser;
    JComboBox religion,income,education,occupation,category;
    String formno;
    SignupTwo(String formno)
   {
     this.formno=formno;
     setLayout(null);
     setTitle("NEW ACCOUNT FORM-PAGE 2");  
        
        
        
        JLabel additionalDetails=new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,20));
        additionalDetails.setBounds(290,80,400,22);
        add(additionalDetails);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300,150,400,20);
        add(religion);
        
        
        
        JLabel religion_name=new JLabel("Religion: ");
        religion_name.setFont(new Font("Raleway",Font.BOLD,15));
        religion_name.setBounds(150,150,400,20);
        add(religion_name);
        
        
        JLabel fname=new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,15));
        fname.setBounds(150,200,400,20);
        add(fname);
        
        String valcategory[]={"General","OBC","SC","ST","Other"};
        category=new JComboBox(valcategory);
        category.setFont(new Font("Raleway",Font.BOLD,12));
        category.setBounds(300,200,400,20);
        add(category);
        
        
       
        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,15));
        dob.setBounds(150,250,400,20);
        add(dob);
        
        String incomecategory[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income=new JComboBox(incomecategory);
        income.setBounds(300,250,400,20);
        income.setForeground(Color.BLACK);
        add(income);
        
        JLabel gender=new JLabel("Education:");
        gender.setFont(new Font("Raleway",Font.BOLD,15));
        gender.setBounds(150,300,400,20);
        add(gender);
        
        String educationValue[]={"Non Graduation","Graduate","Post Graduate","Doctrate","Other"};
        education=new JComboBox(educationValue);
        education.setBounds(300,300,400,20);
        add(education);
        
        
        JLabel email=new JLabel("Occupation:");
        email.setFont(new Font("Raleway",Font.BOLD,15));
        email.setBounds(150,350,400,20);
        add(email);
        
        String occupationValue[]={"Salaried","Self Employed","Business","Student","Retired","Other"};
        occupation=new JComboBox(occupationValue);
        occupation.setFont(new Font("Raleway",Font.BOLD,12));
        occupation.setBounds(300,350,400,20);
        add(occupation);
 
        JLabel address=new JLabel("Pan NO:");
        address.setFont(new Font("Raleway",Font.BOLD,15));
        address.setBounds(150,450,400,20);
        add(address);
        
        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,12));
        pan.setBounds(300,450,400,20);
        add(pan);
        
        
        JLabel city=new JLabel("Identity NO:");
        city.setFont(new Font("Raleway",Font.BOLD,15));
        city.setBounds(150,500,400,20);
        add(city);
        
        identity=new JTextField();
        identity.setFont(new Font("Raleway",Font.BOLD,12));
        identity.setBounds(300,500,400,20);
        add(identity);
        
        
        JLabel state=new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,15));
        state.setBounds(150,550,400,20);
        add(state);
        
        
        syes =new JRadioButton("Yes");
        syes.setBounds(300,550,100,30);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setBounds(450,550,100,30);
        add(sno);
        
        ButtonGroup ageCategory=new ButtonGroup();
        ageCategory.add(sno);
        ageCategory.add(syes);
        
        
        
        JLabel pin=new JLabel("Existing Account:");
        pin.setFont(new Font("Raleway",Font.BOLD,15));
        pin.setBounds(150,600,400,20);
        add(pin);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,600,100,20);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setBounds(450,600,100,20);
        add(eno);
        
        ButtonGroup accountCategory=new ButtonGroup();
        accountCategory.add(eyes);
        accountCategory.add(eno);
        
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
        
        String sreligion=(String) religion.getSelectedItem();
        String scategory=(String) category.getSelectedItem();
        String sincome= (String) income.getSelectedItem();
        String seducation= (String) education.getSelectedItem();
        String soccupation=(String) occupation.getSelectedItem();
        
        String seniorcitizen= null;
        if (syes.isSelected())
        {seniorcitizen="Yes";}
        
        else if (sno.isSelected())
        {seniorcitizen="No";}
        
        
        String existingaccount=null;
        
        if(eyes.isSelected())
        {existingaccount="Yes";}
        
        else if (eno.isSelected())
        {existingaccount="No";}
        
        String sidentity=identity.getText();
        String span=pan.getText();
        
        try
        {
            
            
            if (span.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Pan No is Required");
            }
            
            if (sidentity.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Identity No is Required");
            }
            if (seniorcitizen.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Are you a senior citizen?");
                
            }
            if (existingaccount.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Do you have an existing account");
            }
            
            
            
            
            else{
           Conn c=new Conn();
           
           String query="insert into signuptwo values('"+formno+"','"+sreligion+ "','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+sidentity+"','"+existingaccount+"','"+seniorcitizen+"') ";
           c.s.executeUpdate(query);
           setVisible(false);
           new SignupThree(formno).setVisible(true);
        }}
        
        catch(Exception e)
        {
            System.out.println(e);
        }
       
     
        
      
        
        
    }
    
    
    
    
    
    
    public static void main(String args[])
    {
        new SignupTwo("");
        
    }
    
}
