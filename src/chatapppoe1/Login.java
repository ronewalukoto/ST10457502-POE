

package chatapppoe1;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Login {
    
    
     private String registeredUsername;
     private String registeredPassword;
    
    //Check Username Method
    
        public boolean checkUserName (String userName){
        
           return userName.contains("_") && userName.length() <= 5;
        
        }
    
           
    //Check Password Method
        
        public boolean checkPasswordComplexity (String password) {
        
           return password.length() >= 8 && password.matches(".*[A-Z].*") && 
                  password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*()].*");
            
        }
    
        
    //Check Cellphone Number if in right format
        
        public boolean checkCellPhoneNumber(String phoneNumber) {
        
            String regex = "^\\+\\d{1,3}\\d{1,10}$";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(phoneNumber);

    return matcher.matches();
    
        
            
        }
        
        
    //Check if correct output is displayed when user performs certain actions
        
        public String registerUser(String userName, String password) {
        
        if (!checkUserName(userName)) {
            return "Username is not correctly formatted, please ensure it contains an underscore and is no more than 5 characters long.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure it contains at least 8 characters, an uppercase letter, a number, and a special character.";
        }
        
                    this.registeredUsername = userName;
                    this.registeredPassword = password;
        
        return "Username and password successfully captured";
        
        }
        
        
    //Checks if the user has entered the right login details  
        
        
        public boolean loginUser (String loginUsername, String loginPassword) {
            
           return loginUsername.equals(registeredUsername) && loginPassword.equals(registeredPassword); 
            
        }
        
        
    //This method checks if the right message is displayed when the user tries to login
        
        public String returnLoginStatus (String loginUsername, String loginPassword, String firstName, String lastName) {
        
        if (loginUser(loginUsername, loginPassword)) {
            
            return "Welcome " + firstName + ", " + lastName + ", it is great to see you again.";}
        
        else { return "Username or password incorrect, please try again."; }
            
        }
        
        
}


