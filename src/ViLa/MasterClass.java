
package ViLa;

import javax.swing.JOptionPane;


public class MasterClass {
public boolean checkEmail(String email){
     String s2 = null;
     int n=email.length();
    if(n>=10){
   s2 = email.substring(email.length()-10);
    }
return "@gmail.com".equals(s2)||"@yahoo.com".equals(s2)||"otmail.com".equals(s2);
            
        }
    public int getStringLength(String txt){
       return txt.length();
    }
 public String changeToUpper(String txt){
     return txt.toUpperCase();
     
 }
 


    void valid(String us) {
        if(us==null)
            JOptionPane.showMessageDialog(null,"Please enter the username");
      
  
           
    }
    
    
        void validate(int le, int le1, int le2, int le4,int le3) {
        if(le1==0)
            JOptionPane.showMessageDialog(null,"Enter the First name");
        else if(le2==0)
             JOptionPane.showMessageDialog(null,"Enter the last name");
          else if(le3>6)
          JOptionPane.showMessageDialog(null,"select your gender");
            else if(le4==0)
          JOptionPane.showMessageDialog(null,"Add a comment please");
     else if(le4<50)
          JOptionPane.showMessageDialog(null,"Please expand your comment to 50 characters and above!");
  else if(le4>100)
          JOptionPane.showMessageDialog(null,"Please reduce your comment to 100 characters and below!");
  
           
    }

   
}