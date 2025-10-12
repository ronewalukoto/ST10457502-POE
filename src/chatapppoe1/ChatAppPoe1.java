
package chatapppoe1;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.JOptionPane;

public class ChatAppPoe1 {

 
    public static void main(String[] args) {
        
    //Variable declarations for user information
        
        String firstName;
        String lastName;
        String userName;
        String password;
        String loginUsername;
        String loginPassword;
    
    //Variable declarations for in App use

        String startApp;
        String menu = "--- Welcome to QuickChat. ---\n"
                + "1. Send Messages\n"
                + "2. Recent Sent Messages\n"
                + "3. Quit";
        
        
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
        
        //3. Application Excution
        
            System.out.println("\n--- Press ENTER to start QuickChat :) ---\n");
        
                while (true) {
                    
                    startApp = input.nextLine();
                    
                    if (startApp.trim().isEmpty()) {
                        System.out.println("QuickChat Open, You can minimize this window");
                        break;
                    } else {
                        System.out.println("Invalid input");
                    }
                    
                            }
                
                
                

        Random messID = new Random();
        int numbTexts = 0;

        while (true) {

            String input2 = JOptionPane.showInputDialog(null, menu);

            if (input2.equals("1")) {

                numbTexts = Integer.parseInt(
                        JOptionPane.showInputDialog(null, "How many messages would you like to send?")
                );

                String allMessages = "";
                int totalChars = 0; // <-- Counter for total characters

                for (int i = 1; i <= numbTexts; i++) {

                    // 1. Make 10 digit ID
                    String messageID = "";
                    for (int j = 0; j < 10; j++) {
                        int num = messID.nextInt(10);
                        messageID = messageID + num;
                    }

                    // 2. Enter recipient first
                    String recipient = JOptionPane.showInputDialog(null, "Enter recipient phone number (max 10 digits):");

                    // 3. Enter message text
                    String message = JOptionPane.showInputDialog(null, "Enter message " + i + ":");

                    // 4. Make message hash
                    String[] parts = message.split(" ");
                    String firstWord = parts[0].toUpperCase();
                    String lastWord = parts[parts.length - 1].toUpperCase();
                    String messageHash = messageID.substring(0, 2) + ":" + i + " " + firstWord + " " + lastWord;

                    // Validation in order: messageID → messageHash → recipient → message

                    // a) Check messageID
                    if (messageID.length() != 10) {
                        JOptionPane.showMessageDialog(null, "Invalid message ID!");
                        i--; // redo this message
                        continue;
                    }

                    // b) Check messageHash
                    if (messageHash.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Message hash is empty!");
                        i--;
                        continue;
                    }

                    // c) Check recipient
                    if (recipient.length() > 10 || recipient.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Invalid number. Please enter 1-10 digits.");
                        i--; // redo this message
                        continue;
                    }

                    // d) Check actual message
                    if (message.length() > 250 || message.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter a message of 1-250 characters.");
                        i--; // redo this message
                        continue;
                    }

                    JOptionPane.showMessageDialog(null, "Message " + i + " saved!");

                    // Add message to allMessages
                    allMessages += "Message " + i + ":\n"
                            + "Message ID: " + messageID + "\n"
                            + "Message Hash: " + messageHash + "\n"
                            + "Recipient: " + recipient + "\n"
                            + "Text: " + message + "\n";

                    // Add to total character count
                    totalChars += message.length(); // <-- count only the message text
                }

                // Ask what to do with the messages
                String[] options = {"Send Message", "Disregard Message", "Store Message to send later"};
                int choice = JOptionPane.showOptionDialog(null,
                        "All Messages:\n\n" + allMessages + "\nChoose what to do:",
                        "QuickChat",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[0]);

                if (choice == 0) {
                    JOptionPane.showMessageDialog(null, "Messages sent successfully!\nTotal characters used: " + totalChars);
                } else if (choice == 1) {
                    JOptionPane.showMessageDialog(null, "Messages disregarded.");
                } else if (choice == 2) {
                    JOptionPane.showMessageDialog(null, "Messages stored to send later.\nTotal characters used: " + totalChars);

                    // Save messages in JSON format
                    try {
                        String[] messagesArray = allMessages.split("\n\n");
                        String jsonMessages = "[\n";

                        for (int j = 0; j < messagesArray.length; j++) {
                            String msg = messagesArray[j].replace("\n", "\", \"").replace(": ", "\": \"");
                            jsonMessages += "  {\n    \"" + msg + "\"\n  }";
                            if (j != messagesArray.length - 1) {
                                jsonMessages += ",\n";
                            }
                        }

                        jsonMessages += "\n]\n";

                        java.io.FileWriter writer = new java.io.FileWriter("messages.json", true); // append
                        writer.write(jsonMessages);
                        writer.close();

                        JOptionPane.showMessageDialog(null, "Messages saved to messages.json successfully!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error saving messages: " + e.getMessage());
                    }
                }
            }

            else if (input2.equals("2")) {
                JOptionPane.showMessageDialog(null, "Coming Soon!");
            }

            else if (input2.equals("3")) {
                JOptionPane.showMessageDialog(null, "Exiting QuickChat. Goodbye!");
                break;
            }

            else {
                JOptionPane.showMessageDialog(null, "Invalid choice! Please type 1, 2, or 3.");
            }
        } 

    /*
    References:
      
        References (AI attribution for phone number validation):
        ChatGPT (2025, September 15) Asked for a guideline for validating phone numbers with country code. OpenAI.
        Prompt: “Create a guideline for validating phone numbers with country code.”
         
    
    
    */
    
      
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
    
    

