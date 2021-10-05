
package ViLa;
import account.*;
import java.awt.Color;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
public class LoginE implements ActionListener{
    
    //creation of objects of Jcomponents that will be used to create Login Page
JFrame f=new JFrame();
JPanel p=new JPanel();
JButton b1=new JButton("Login");
JLabel l=new JLabel("user name");
JLabel l1=new JLabel("password");
JLabel l2=new JLabel("The password length should be between 8 and 12.\n" +
" The password should only contain Upper case letters.");
JTextField t=new JTextField();
JPasswordField t1=new JPasswordField();


//Constractor to set character to the objects
    LoginE(){
    l.setBounds(100, 170, 100, 30);
    t.setBounds(200, 170, 100, 30);
   
    l1.setBounds(100, 250, 100, 30);
    t1.setBounds(200,250, 100, 30);
    b1.setBounds(200, 300, 100, 30);
     //l2.setBounds(10, 120, 400, 200);
    b1.addActionListener(this);
    
   // Add object to panel
    p.add(b1);
    p.add(l);
    p.add(l1);
   // p.add(l2);
    p.add(t);
    p.add(t1);
    p.setBackground(Color.lightGray);


    p.setLayout(null);
    p.setVisible(true);
    p.setBounds(0, 0, 465,500);
    
    
    f.add(p);
    f.setTitle("Login Page");
    f.setLayout(null);
    f.setVisible(true);
    
      f.setBounds(900, 250, 465,500);
    }

    @Override
@SuppressWarnings("deprecation")
    public void actionPerformed(ActionEvent e) {
         @SuppressWarnings("deprecation")
        String s1,s2=null,pwd = null;
     s1 = t.getText();
    s2 = t1.getText();
        
        
        try

        {         
            
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","Angelus","cri1@ERN");    
                        
 String s=s1;
                 
            Statement stmt = con.createStatement(); 
            
  
              //Creaing Java ResultSet object
           
         
              ResultSet resultSet=stmt.executeQuery("select* from experts WHERE Id = '" + s +"'");
            while(resultSet.next()){
                 String id=resultSet.getString("Id");
                   String fname=resultSet.getString("Fname");
                    String lname=resultSet.getString("Lname");
                      String Email=resultSet.getString("Email");
                     String sex=resultSet.getString("Gender");
                     
                    
                     pwd=resultSet.getString("Password");
                     
                   
                   //Printing Results
                
                 
    

        

        } 
            con.close();

       }catch(SQLException e2){
                e2.printStackTrace();
 
          }
        
        
         System.out.println(s2+pwd);
      if(e.getSource()==b1){//&&pwd.equals(s2)
   
           new account.Experts().setVisible(true);
      
    t.setText("");
    t1.setText("");
      }
      else{
          JOptionPane.showMessageDialog(null, "Please enter valid password");
          t1.setText("");
     }
   
    }
    public static void main(String[] args) {

    LoginE loginPage;
    LoginE n= new LoginE();
 
 
    }
}
