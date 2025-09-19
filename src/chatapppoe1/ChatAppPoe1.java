
package chatapppoe1;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ChatAppPoe1 {

 
    public static void main(String[] args) {
        
    //Variable declarations for user information
        
        String firstName;
        String lastName;
        String userName;
        String password;
        String loginUsername;
        String loginPassword;
        
        Scanner input = new Scanner(System.in); //Scanner, this allows the user to input need informaation
            
        System.out.println("\n--- Registration ---\n");
        
    //First & Last Name

        System.out.println("Enter your first name: \n");
        
            firstName = input.nextLine(); //This allows the user to input their First Name
        
        System.out.println("\nEnter your last name: \n");
        
            lastName = input.nextLine();  //This allows the user to input their Last Name
       
    //1. Username
       
       while (true) {
            
            System.out.println("\nEnter your new username??\n"); 
        
                userName = input.nextLine();
            
            // Verifies that the username is no more than five characters and contains an underscore.    
            if (userName.contains("_") && userName.length() <= 5) {
                System.out.println("\nUsername successfully captured.\n");
                break; //This will exit the loop if the user input the correct format of the username.
        } else {
                System.out.println("\nUsername is not correctly formatted. Please ensure that your username contains an underscore and is no more than five characters in length.\n");  // Error message for invalid username
            }
                    
            
          } 
       
         
       //2. Password
       
        while (true){

            System.out.println("\nEnter new password: \n");
            
                password = input.nextLine();

            if (password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*()].*")
 ) {
                System.out.println("\nPassword successfully captured.\n");
                break;
           } else {
                System.out.println("\nPassword is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.\n");
            }
            
        
                    }
        
    //Display Username and Password to User
            System.out.println("New Username: " + userName);
            System.out.println("New Password: " + password);
            
            
    //1b) Cellphone Number
    
        while (true) {            
           
            System.out.println("\nEnter your cell phone number (with international code): \n");
        String phoneNumber = input.nextLine();

        // Regular expression: starts with +, 1-3 digits country code, then up to 10 digits
        String regex = "^\\+\\d{1,3}\\d{1,10}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.matches()) {
            System.out.println("\nCell phone number successfully added.\n");
            break;
        } else {
            System.out.println("\nCell phone number incorrectly formatted or does not contain international code.\n");
        }
        //
        
                        }
    
        
        
        
    //2. Login
    
        while (true) {            
            // Retrieve the password and username entered for the login
          System.out.println("\nPlease Login with your created creditials\n");
        
            System.out.println("\nEnter your username\n");
                loginUsername = input.nextLine();
                
            System.out.println("\nEnter your password\n");
                loginPassword = input.nextLine();
            // Check if login matches the registered username and password       
        if (loginUsername.equals(userName) && loginPassword.equals(password)) {
            System.out.println("\nWelcome " + firstName + ", " + lastName + ", it is great to see you again.\n");
            break;
        } else {
            System.out.println("\nUsername or password incorrect, please try again.\n");
        }  
        
                    }
        
        
    
    
}

    /*
    References:
      
        References (AI attribution for phone number validation):
        ChatGPT (2025, September 15) Asked for a guideline for validating phone numbers with country code. OpenAI.
        Prompt: “Create a guideline for validating phone numbers with country code.”
         
    
    
    */
    
    
 
}
    
    
    
    

