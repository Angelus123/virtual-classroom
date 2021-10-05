package ViLa;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
 
public class StudentsReg implements ActionListener {
    JFrame frame;
    String[] gender={"Male","Female"};
    JLabel firstNameLabel=new JLabel("RegNo");
    JLabel lastNameLabel=new JLabel("First Name");
    JLabel emailLabel=new JLabel("Last Name");
    JLabel genderLabel=new JLabel("Gender");
    JLabel facultyLabel=new JLabel("Email");
    JLabel levelLabel=new JLabel("Level");
    JLabel passwordLabel=new JLabel("Password");
    JLabel confirmPasswordLabel=new JLabel("Confirm Password");
    
   
    JTextField firstNameTextField=new JTextField();
    JTextField lastNAmeTextField=new JTextField();
    JTextField emailTextField=new JTextField();
    JComboBox genderComboBox=new JComboBox(gender);
    JTextField facultyTextField=new JTextField();
    JTextField levelTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JPasswordField confirmPasswordField=new JPasswordField();
    
    JButton registerButton=new JButton("Register");
    JButton resetButton=new JButton("Reset");
    JButton loginButton=new JButton("Login");
 
 
    StudentsReg()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame=new JFrame();
        frame.setTitle("Registration Form");
        frame.setBounds(900, 125, 465,500);
        frame.getContentPane().setBackground(Color.getHSBColor(101,501,101));
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    public void setLocationAndSize()
    {
       firstNameLabel.setBounds(20,20,100,10);
       lastNameLabel.setBounds(20,70,100,10); 
       emailLabel.setBounds(20,120,100,10);
       genderLabel.setBounds(20,170,80,10);
       facultyLabel.setBounds(20,220,80,10);
       levelLabel.setBounds(20,270,80,10);
       passwordLabel.setBounds(20,320,100,10);
       confirmPasswordLabel.setBounds(20,370,140,10);
        
       
        firstNameTextField.setBounds(180,20,165,25);
        lastNAmeTextField.setBounds(180,70,165,25);
        emailTextField.setBounds(180,120,165,25);        
        genderComboBox.setBounds(180,170,165,25);
       
        facultyTextField.setBounds(180,220,165,25);
        levelTextField.setBounds(180,270,165,25);
     
        
        passwordField.setBounds(180,320,165,25);
        confirmPasswordField.setBounds(180,370,165,25);
        
        
        registerButton.setBounds(120,400,90,35);
        resetButton.setBounds(220,400,90,35);
        loginButton.setBounds(320,400,90,35);
    }
    public void addComponentsToFrame()
    {
        frame.add(firstNameLabel);
         frame.add(lastNameLabel);
          frame.add(emailLabel);
        frame.add(genderLabel);
       frame.add(facultyLabel);
       frame.add(levelLabel);
        frame.add(passwordLabel);
        frame.add(confirmPasswordLabel);
       
      
        frame.add(firstNameTextField);
        
        frame.add(lastNAmeTextField);
        frame.add(emailTextField);
        frame.add(genderComboBox);
        frame.add(facultyTextField);
        frame.add(levelTextField);
        
        frame.add(passwordField);
        frame.add(confirmPasswordField);
       
        frame.add(registerButton);
        frame.add(resetButton);
        frame.add(loginButton);
    }
    public void actionEvent()
    {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
         loginButton.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registerButton)
        {
            try {
                //Creating Connection Object
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","Angelus","cri1@ERN");
                //Preapared Statement
                PreparedStatement Pstatement=connection.prepareStatement("insert into students values(?,?,?,?,?,?,?,?)");
                //Specifying the values of it's parameter
                Pstatement.setString(1,firstNameTextField.getText());
                Pstatement.setString(2,lastNAmeTextField.getText());
                Pstatement.setString(3,facultyTextField.getText());
                Pstatement.setString(4,levelTextField.getText());
                Pstatement.setString(5,genderComboBox.getSelectedItem().toString());
                Pstatement.setString(6,emailTextField.getText());
                Pstatement.setString(7,passwordField.getText());
                 Pstatement.setString(8,confirmPasswordField.getText());
                
              
               
                
                //Checking for the Password match
                if(passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText()))
                {
                    //Executing query
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"password did not match");
                }
 
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
 
 
        }
        if(e.getSource()==resetButton)
        {
            //Clearing Fields
            firstNameTextField.setText("");
            lastNAmeTextField.setText("");
            genderComboBox.setSelectedItem("Male");
            facultyTextField.setText("");
            levelTextField.setText("");
            emailTextField.setText("");
            passwordField.setText("");
            confirmPasswordField.setText("");
           
          
        }
         if(e.getSource()==loginButton)
        { 
        new Login();
        }
 
    }
    
    
    public static void main(String[] args)
    {
        new StudentsReg();
        // new MySQLJDBCUtil();
    }
}