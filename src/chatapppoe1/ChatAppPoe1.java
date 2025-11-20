package chatapppoe1;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * ChatAppPoe1
 *
 * Full implementation with arrays and message tools as requested.
 *
 * Requires json-simple library on the classpath:
 *  - groupId: com.googlecode.json-simple
 *  - artifactId: json-simple
 */
public class ChatAppPoe1 {

    public static void main(String[] args) {
        // Variable declarations for user information
        String firstName;
        String lastName;
        String userName;
        String password;
        String loginUsername;
        String loginPassword;

        // Variable declarations for in App use
        String startApp;
        String menu = "--- Welcome to QuickChat. ---\n"
                + "1. Send Messages\n"
                + "2. Recent Sent Messages\n"
                + "3. Message Tools\n"
                + "4. Quit";

        Scanner input = new Scanner(System.in); // Scanner, this allows the user to input needed information

        System.out.println("\n--- Registration ---\n");

        // First & Last Name
        System.out.println("Enter your first name: \n");
        firstName = input.nextLine(); // This allows the user to input their First Name

        System.out.println("\nEnter your last name: \n");
        lastName = input.nextLine();  // This allows the user to input their Last Name

        // 1. Username
        while (true) {
            System.out.println("\nEnter your new username??\n");
            userName = input.nextLine();

            // Verifies that the username is no more than five characters and contains an underscore.
            if (userName.contains("_") && userName.length() <= 5) {
                System.out.println("\nUsername successfully captured.\n");
                break; // This will exit the loop if the user input the correct format of the username.
            } else {
                System.out.println("\nUsername is not correctly formatted. Please ensure that your username contains an underscore and is no more than five characters in length.\n");  // Error message for invalid username
            }
        }

        // 2. Password
        while (true) {
            System.out.println("\nEnter new password: \n");
            password = input.nextLine();

            if (password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*()].*")) {
                System.out.println("\nPassword successfully captured.\n");
                break;
            } else {
                System.out.println("\nPassword is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.\n");
            }
        }

        // Display Username and Password to User
        System.out.println("New Username: " + userName);
        System.out.println("New Password: " + password);

        // 1b) Cellphone Number
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
        }

        // 2. Login
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

        // === NEW DATA STRUCTURES REQUIRED BY THE TASK ===
        // The lecturer requested arrays; here we store data in ArrayLists for flexibility
        // They act as the arrays the students will use (you can use .toArray if a raw array is needed)
        ArrayList<JSONObject> sentMessages = new ArrayList<>();       // Each JSONObject contains message fields
        ArrayList<JSONObject> disregardedMessages = new ArrayList<>(); // Disregarded messages
        ArrayList<JSONObject> storedMessages = new ArrayList<>();     // Messages read from messages.json
        ArrayList<String> messageHashes = new ArrayList<>();
        ArrayList<String> messageIDs = new ArrayList<>();

        // Attempt to load stored messages from messages.json at startup (if file exists)
        File jsonFile = new File("messages.json");
        if (jsonFile.exists()) {
            try (FileReader fr = new FileReader(jsonFile)) {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(fr);
                if (obj instanceof JSONArray) {
                    JSONArray arr = (JSONArray) obj;
                    for (Object o : arr) {
                        if (o instanceof JSONObject) {
                            JSONObject jo = (JSONObject) o;
                            storedMessages.add(jo);
                        }
                    }
<<<<<<< HEAD
                }
            } catch (Exception e) {
                // If parsing fails, we continue with empty storedMessages
                System.err.println("Warning: could not read messages.json on startup: " + e.getMessage());
            }
        }

        // 3. Application Execution
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
=======
        
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
                
         //This is wherew the app truly starts       
                
>>>>>>> 5615506073dcb6a5951141403a6838c5f2fe4d22

        Random messID = new Random();
        int numbTexts = 0;

        // main loop
        while (true) {
            String input2 = JOptionPane.showInputDialog(null, menu);

            if (input2 == null) { // user pressed cancel
                JOptionPane.showMessageDialog(null, "Exiting QuickChat. Goodbye!");
                break;
            }

            if (input2.equals("1")) {
                // SEND MESSAGES flow (your original flow, with added array population)
                try {
                    numbTexts = Integer.parseInt(
                            JOptionPane.showInputDialog(null, "How many messages would you like to send?")
                    );
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Invalid number input. Returning to menu.");
                    continue;
                }

                String allMessages = "";
                int totalChars = 0; // Total number of characters used

                // We'll collect each message block separately so we can store them individually
                ArrayList<String> messageBlocks = new ArrayList<>();

<<<<<<< HEAD
                for (int i = 1; i <= numbTexts; i++) {
                    // 1. Make 10 digit ID
=======
                    // 1. Creates random 10 digit ID
>>>>>>> 5615506073dcb6a5951141403a6838c5f2fe4d22
                    String messageID = "";
                    for (int j = 0; j < 10; j++) {
                        int num = messID.nextInt(10);
                        messageID = messageID + num;
                    }

<<<<<<< HEAD
                    // 2. Enter recipient first (validated max 10 digits)
                    String recipient = "";
                    while (true) {
                        recipient = JOptionPane.showInputDialog(null, "Enter recipient phone number (max 10 digits):");
                        if (recipient == null) {
                            JOptionPane.showMessageDialog(null, "Message creation cancelled. Returning to menu.");
                            break;
                        }
                        if (!recipient.isEmpty() && recipient.length() <= 10) {
                            break; // valid number
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid number. Please enter 1–10 digits.");
                        }
                    }
                    if (recipient == null) {
                        break; // cancel outer loop
                    }
=======
                    // 2. The user enters the number of the recipient
                    
                    String recipient = "";
                while (true) {
                    recipient = JOptionPane.showInputDialog(null, "Enter recipient phone number (max 10 digits):");
                        if (!recipient.isEmpty() && recipient.length() <= 10) {
                            break; // valid number
                        } else {
                                JOptionPane.showMessageDialog(null, "Invalid number. Please enter 1–10 digits.");
                                }
                            }
>>>>>>> 5615506073dcb6a5951141403a6838c5f2fe4d22

                    

                    // 3. Thee user then enters a message
                    String message = JOptionPane.showInputDialog(null, "Enter message " + i + ":");
                    if (message == null) {
                        JOptionPane.showMessageDialog(null, "Message creation cancelled. Returning to menu.");
                        break;
                    }

<<<<<<< HEAD
                    // 4. Make message hash
                    // Ensure message has at least one word
                    String[] parts = message.trim().split("\\s+");
                    String firstWord = parts.length >= 1 ? parts[0].toUpperCase() : "";
                    String lastWord = parts.length >= 1 ? parts[parts.length - 1].toUpperCase() : "";
                    String messageHash = messageID.substring(0, 2) + ":" + i + " " + firstWord + " " + lastWord;

                    // Validation in order: messageID → messageHash → recipient → message
                    if (messageID.length() != 10) {
                        JOptionPane.showMessageDialog(null, "Invalid message ID!");
                        i--; // redo this message
                        continue;
                    }

                    if (messageHash.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Message hash is empty!");
                        i--;
                        continue;
                    }

                    if (recipient.length() > 10 || recipient.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Invalid number. Please enter 1-10 digits.");
                        i--; // redo this message
                        continue;
                    }

                    if (message.length() > 250 || message.isEmpty()) {
=======
                    // 4.  message hash
                    String[] parts = message.split(" ");
                    String firstWord = parts[0].toUpperCase();
                    String lastWord = parts[parts.length - 1].toUpperCase();
                    String messageHash = messageID.substring(0, 2) + ":" + i + " " + firstWord + " " + lastWord;

                    // Validation, here the user will check if their message is right
                    // d) Check actual message
                    if (message.length() > 250 || message.length() <1) {
>>>>>>> 5615506073dcb6a5951141403a6838c5f2fe4d22
                        JOptionPane.showMessageDialog(null, "Please enter a message of 1-250 characters.");
                        i--; // redo this message
                        continue;
                    }

                    JOptionPane.showMessageDialog(null, "Message " + i + " saved!");

<<<<<<< HEAD
                    // Build human-readable block for display and for storing to arrays
                    String block = "Message " + i + ":\n"
=======
                    // Displays all the messages to the use4
                    allMessages += "Message " + i + ":\n"
>>>>>>> 5615506073dcb6a5951141403a6838c5f2fe4d22
                            + "Message ID: " + messageID + "\n"
                            + "Message Hash: " + messageHash + "\n"
                            + "Recipient: " + recipient + "\n"
                            + "Text: " + message + "\n";

<<<<<<< HEAD
                    allMessages += block + "\n";
                    messageBlocks.add(block);

                    totalChars += message.length(); // <-- count only the message text
=======
                    //Total character count
                    totalChars += message.length();
>>>>>>> 5615506073dcb6a5951141403a6838c5f2fe4d22
                }

                // AskS what the user do with the messages
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
                    // SEND - add each individual message to sentMessages array (ArrayList)
                    for (String mb : messageBlocks) {
                        JSONObject mObj = parseMessageBlockToJSON(mb);
                        if (mObj != null) {
                            sentMessages.add(mObj);
                            // also store ids and hashes separate lists
                            Object idObj = mObj.get("Message ID");
                            if (idObj != null) messageIDs.add(idObj.toString());
                            Object hashObj = mObj.get("Message Hash");
                            if (hashObj != null) messageHashes.add(hashObj.toString());
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Messages sent successfully!\nTotal characters used: " + totalChars);
                } else if (choice == 1) {
                    // DISREGARD - add to disregardedMessages list
                    for (String mb : messageBlocks) {
                        JSONObject mObj = parseMessageBlockToJSON(mb);
                        if (mObj != null) {
                            disregardedMessages.add(mObj);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Messages disregarded.");
                } else if (choice == 2) {
<<<<<<< HEAD
                    // STORE - write messages to JSON file and add to storedMessages list
=======
                    JOptionPane.showMessageDialog(null, "Messages stored to send later.\nTotal characters used: " + totalChars);

                    // Storing messages in the JSON format
>>>>>>> 5615506073dcb6a5951141403a6838c5f2fe4d22
                    try {
                        // Load existing array if present
                        JSONArray jsonArray = new JSONArray();
                        JSONParser parser = new JSONParser();
                        if (jsonFile.exists()) {
                            try (FileReader fr = new FileReader(jsonFile)) {
                                Object obj = parser.parse(fr);
                                if (obj instanceof JSONArray) {
                                    jsonArray = (JSONArray) obj;
                                }
                            } catch (Exception ex) {
                                // if file exists but parsing fails, we will overwrite with new array
                                jsonArray = new JSONArray();
                            }
                        }

                        // Append each message as a JSONObject
                        for (String mb : messageBlocks) {
                            JSONObject mObj = parseMessageBlockToJSON(mb);
                            if (mObj != null) {
                                jsonArray.add(mObj);
                                storedMessages.add(mObj);
                                Object idObj = mObj.get("Message ID");
                                if (idObj != null) messageIDs.add(idObj.toString());
                                Object hashObj = mObj.get("Message Hash");
                                if (hashObj != null) messageHashes.add(hashObj.toString());
                            }
                        }

                        // Write back to file (overwrite with valid JSON)
                        try (FileWriter fw = new FileWriter("messages.json")) {
                            fw.write(jsonArray.toJSONString());
                            fw.flush();
                        }

                        JOptionPane.showMessageDialog(null, "Messages stored to messages.json successfully!\nTotal characters used: " + totalChars);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error saving messages: " + e.getMessage());
                    }
                }
            } // end input2 == "1"

            else if (input2.equals("2")) {
                // Recent Sent Messages - show the messages in sentMessages array
                if (sentMessages.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No sent messages to show.");
                } else {
                    StringBuilder sb = new StringBuilder();
                    int idx = 1;
                    for (JSONObject jo : sentMessages) {
                        sb.append("Sent #").append(idx++).append(":\n");
                        sb.append(formatJSONObjectForDisplay(jo)).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                }

<<<<<<< HEAD
            } else if (input2.equals("3")) {
                // Message Tools - provides a sub-menu for tasks (a-f)
                String toolMenu = "Message Tools:\n"
                        + "1. Display sender and recipient of all sent messages\n"
                        + "2. Display the longest sent message\n"
                        + "3. Search for a message ID and display recipient & message\n"
                        + "4. Search for all messages sent to a recipient\n"
                        + "5. Delete a message using the message hash\n"
                        + "6. Display a full report of all sent messages\n";
                        
                String toolChoice = JOptionPane.showInputDialog(null, toolMenu);

                if (toolChoice == null) continue;

                switch (toolChoice) {
                    case "1":
                        // a) Display the sender and recipient of all sent messages.
                        // Note: the "sender" is the logged-in user (firstName lastName)
                        if (sentMessages.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No sent messages available.");
                        } else {
                            StringBuilder sr = new StringBuilder();
                            for (int i = 0; i < sentMessages.size(); i++) {
                                JSONObject m = sentMessages.get(i);
                                String recipient = m.getOrDefault("Recipient", "").toString();
                                sr.append("Sender: ").append(firstName).append(" ").append(lastName)
                                        .append(" | Recipient: ").append(recipient).append("\n");
                            }
                            JOptionPane.showMessageDialog(null, sr.toString());
                        }
                        break;

                    case "2":
                        // b) Display the longest sent message (by text length)
                        if (sentMessages.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No sent messages available.");
                        } else {
                            JSONObject longestObj = null;
                            int longestLen = -1;
                            for (JSONObject m : sentMessages) {
                                String text = m.getOrDefault("Text", "").toString();
                                if (text.length() > longestLen) {
                                    longestLen = text.length();
                                    longestObj = m;
                                }
                            }
                            if (longestObj != null) {
                                JOptionPane.showMessageDialog(null, "Longest message (" + longestLen + " chars):\n"
                                        + formatJSONObjectForDisplay(longestObj));
                            } else {
                                JOptionPane.showMessageDialog(null, "Could not determine longest message.");
                            }
                        }
                        break;

                    case "3":
                        // c) Search for a message ID and display the corresponding recipient and message.
                        String searchID = JOptionPane.showInputDialog("Enter Message ID to search:");
                        if (searchID == null || searchID.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No ID entered.");
                        } else {
                            boolean found = false;
                            for (JSONObject m : sentMessages) {
                                if (searchID.equals(m.getOrDefault("Message ID", "").toString())) {
                                    String recipient = m.getOrDefault("Recipient", "").toString();
                                    String text = m.getOrDefault("Text", "").toString();
                                    JOptionPane.showMessageDialog(null, "Found:\nRecipient: " + recipient + "\nMessage: " + text);
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                JOptionPane.showMessageDialog(null, "Message ID not found in sent messages.");
                            }
                        }
                        break;

                    case "4":
                        // d) Search for all the messages sent to a particular recipient.
                        String searchRecipient = JOptionPane.showInputDialog("Enter recipient number to search:");
                        if (searchRecipient == null || searchRecipient.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No recipient entered.");
                        } else {
                            StringBuilder matches = new StringBuilder();
                            for (JSONObject m : sentMessages) {
                                if (searchRecipient.equals(m.getOrDefault("Recipient", "").toString())) {
                                    matches.append(formatJSONObjectForDisplay(m)).append("\n");
                                }
                            }
                            if (matches.length() == 0) {
                                JOptionPane.showMessageDialog(null, "No messages found for recipient: " + searchRecipient);
                            } else {
                                JOptionPane.showMessageDialog(null, matches.toString());
                            }
                        }
                        break;

                    case "5":
                        // e) Delete a message using the message hash.
                        String delHash = JOptionPane.showInputDialog("Enter the message hash to delete:");
                        if (delHash == null || delHash.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No hash entered.");
                        } else {
                            boolean removed = false;
                            for (int i = 0; i < sentMessages.size(); i++) {
                                JSONObject m = sentMessages.get(i);
                                if (delHash.equals(m.getOrDefault("Message Hash", "").toString())) {
                                    // move the message to disregardedMessages for safety (or just remove)
                                    disregardedMessages.add(m);
                                    sentMessages.remove(i);
                                    // also remove from messageHashes and messageIDs lists if present
                                    messageHashes.remove(delHash);
                                    Object idVal = m.get("Message ID");
                                    if (idVal != null) messageIDs.remove(idVal.toString());
                                    removed = true;
                                    break;
                                }
                            }
                            if (removed) {
                                JOptionPane.showMessageDialog(null, "Message with hash " + delHash + " deleted and moved to disregarded messages.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Message hash not found in sent messages.");
                            }
                        }
                        break;

                    case "6":
                        // f) Display a report that lists the full details of all the sent messages.
                        if (sentMessages.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No sent messages to report.");
                        } else {
                            // Sort by message ID (optional) to give a consistent report order
                            sentMessages.sort(new java.util.Comparator<JSONObject>() {
                                @Override
                                public int compare(JSONObject o1, JSONObject o2) {
                                    String id1 = o1.getOrDefault("Message ID", "").toString();
                                    String id2 = o2.getOrDefault("Message ID", "").toString();
                                    return id1.compareTo(id2);
                                }
                            });

                            StringBuilder report = new StringBuilder();
                            int count = 1;
                            for (JSONObject m : sentMessages) {
                                report.append("Sent Message #").append(count++).append("\n");
                                report.append(formatJSONObjectForDisplay(m)).append("\n\n");
                            }
                            JOptionPane.showMessageDialog(null, report.toString());
                        }
                        break;

                    case "7":
                        // Reload stored messages from messages.json
                        storedMessages.clear();
                        if (jsonFile.exists()) {
                            try (FileReader fr = new FileReader(jsonFile)) {
                                JSONParser parser = new JSONParser();
                                Object parsed = parser.parse(fr);
                                if (parsed instanceof JSONArray) {
                                    JSONArray arr = (JSONArray) parsed;
                                    for (Object o : arr) {
                                        if (o instanceof JSONObject) {
                                            storedMessages.add((JSONObject) o);
                                        }
                                    }
                                }
                                JOptionPane.showMessageDialog(null, "Stored messages reloaded from messages.json (" + storedMessages.size() + " entries).");
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Error loading stored messages: " + e.getMessage());
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "messages.json does not exist.");
                        }
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Invalid Message Tools choice.");
                        break;
                }

            } else if (input2.equals("4")) {
                JOptionPane.showMessageDialog(null, "Exiting QuickChat. Goodbye!");
=======
            else if (input2.equals("3")) {
                JOptionPane.showMessageDialog(null, "Exiting QuickChat");
>>>>>>> 5615506073dcb6a5951141403a6838c5f2fe4d22
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice! Please type 1, 2, 3 or 4.");
            }
        } // end main loop

<<<<<<< HEAD
        // Clean up scanner
        input.close();
    } // end main

   
    private static JSONObject parseMessageBlockToJSON(String block) {
        if (block == null) return null;
        String[] lines = block.split("\\r?\\n");
        JSONObject jo = new JSONObject();
        for (String line : lines) {
            if (line.contains(":")) {
                int idx = line.indexOf(":");
                String key = line.substring(0, idx).trim();
                String val = line.substring(idx + 1).trim();
                // For "Message N" header lines like "Message 1:" the key will be "Message 1"
                jo.put(key, val);
=======
            else {
                JOptionPane.showMessageDialog(null, "Invalid! Please type 1, 2, or 3.");
>>>>>>> 5615506073dcb6a5951141403a6838c5f2fe4d22
            }
        }
        // Remove the "Message N" header if present as it's not a data field
        jo.remove("Message 1");
        jo.remove("Message 2");
        jo.remove("Message 3");
        // etc - safe to leave if absent
        return jo;
    }

 
    private static String formatJSONObjectForDisplay(JSONObject jo) {
        if (jo == null) return "";
        StringBuilder sb = new StringBuilder();
        if (jo.containsKey("Message ID")) sb.append("Message ID: ").append(jo.get("Message ID")).append("\n");
        if (jo.containsKey("Message Hash")) sb.append("Message Hash: ").append(jo.get("Message Hash")).append("\n");
        if (jo.containsKey("Recipient")) sb.append("Recipient: ").append(jo.get("Recipient")).append("\n");
        if (jo.containsKey("Text")) sb.append("Text: ").append(jo.get("Text")).append("\n");
        // include other keys if present
        for (Object k : jo.keySet()) {
            String key = k.toString();
            if (!key.equals("Message ID") && !key.equals("Message Hash") && !key.equals("Recipient") && !key.equals("Text")) {
                sb.append(key).append(": ").append(jo.get(key)).append("\n");
            }
        }
        return sb.toString();
    }
}
