package chatapppoe1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.Test;

public class ChatAppPoe1Test {
    
     Login login = new Login(); // Login object to access the methods to be tested
     
    public ChatAppPoe1Test() {
    }
    
    //
    @Test
    public void testCheckUserName() {
        
       boolean actual = login.checkUserName("kyl_1");
        assertEquals(Boolean.TRUE, actual);

        // Incorrectly formatted username
        actual = login.checkUserName("kyle!!!!!!!");
        assertEquals(Boolean.FALSE, actual);
            
        }
    //
    @Test
    public void testcheckPasswordComplexity() {
    
        boolean actual = login.checkPasswordComplexity("Ch&&sec@ke99!");
            assertEquals(Boolean.TRUE, actual);
            
        // Incorrectly formatted password
        actual = login.checkPasswordComplexity("password");
        assertEquals(Boolean.FALSE, actual);    
    
    }
    
   //
   @Test
   public void testcheckCellPhoneNumber() {
   
         boolean actual = login.checkCellPhoneNumber("+27838968976");
            assertEquals(Boolean.TRUE, actual);
            
        // Incorrectly formatted Cellphonr number
        actual = login.checkCellPhoneNumber("08966553");
        assertEquals(Boolean.FALSE, actual);    
   
   }
    
   //
   @Test
   public void testLoginUser() {
   
       // Register a username and password first
    login.registerUser("kyl_1", "Ch&&sec@ke99!");

    // Correct login
    assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));

    // Incorrect login
    assertFalse(login.loginUser("kyl_2", "123456abc"));
       
   }
   
   
   
   
   
   
   
    
}
    
    

