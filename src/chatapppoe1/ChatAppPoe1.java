
package chatapppoe1;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ChatAppPoe1 {

 
    public static void main(String[] args) {
        
    //Declarations
        String userName;
        String password;
        String loginUsername;
        String loginPassword;
        
        Scanner input = new Scanner(System.in);
       
    //1. Username
       
       while (true) {
            
            System.out.println("Enter your new username??");
        
                userName = input.nextLine();
            
            if (userName.contains("_") && userName.length() <= 5) {
                System.out.println("Username Captured Successfully");
                break;
        } else {
                System.out.println("Username is incorrect format");
            }
                    
            
          } 
       
         
       //2. Password
       
        while (true){

            System.out.println("Enter new password: ");
            
                password = input.nextLine();

            if (password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*()].*")
 ) {
                System.out.println("Password Captured Successful");
                break;
           } else {
                System.out.println("Password not in correct format");
            }
            
        
                    }
        
    //Display Username and Password to User
            System.out.println("New Username: " + userName);
            System.out.println("New Password: " + password);
            
            
    //1b) Cellphone Number
    
         System.out.println("Enter your cell phone number (with international code): ");
        String phoneNumber = input.nextLine();

        // Regular expression: starts with +, 1-3 digits country code, then up to 10 digits
        String regex = "^\\+\\d{1,3}\\d{1,10}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.matches()) {
            System.out.println("Cell phone number successfully added.");
        } else {
            System.out.println("Cell phone number incorrectly formatted.");
        }
        //[Refernce]
        
        
    //2. Login
        
        System.out.println("Please Login with your created creditials");
        
            System.out.println("Enter your username");
                loginUsername = input.nextLine();
                
            System.out.println("Enter your password");
                loginPassword = input.nextLine();
                
        if (loginUsername.equals(userName) && loginPassword.equals(password)) {
            System.out.println("Welcome " + loginUsername + ", it is great to see you again.");
        } else {
            System.out.println("Username or password incorrect, please try again.");
        }
    
    
}
  
 
}
    
    
    
    

