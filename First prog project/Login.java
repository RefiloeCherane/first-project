package ST10269417.Refiloe.Cherane.POE;
/**
 *
 * @author ST10269417 Refiloe Cherane
 */
import javax.swing.JOptionPane;

public class Login {
    
    public boolean checkUserName(){
        if(Registration.username.contains("_") && Registration.username.length() <= 5){
            return true;
        } else {
            return false;
        } 
    }
    
    public boolean checkPasswordComplexity(){
        boolean passwordStatus = false;
        boolean length = false;
        boolean number = false;
        boolean specialCharacter = false;
        boolean upperCase = false;
        char ch;
        
        if(Registration.password.length() >= 8){
            length = true;
        }
        for(int i = 0; i < Registration.password.length(); i++){
            ch = Registration.password.charAt(i);
            
            if(Character.isDigit(ch)){
                number = true;
            }
            if(Character.isUpperCase(ch)){
                upperCase = true;
            }
            if(!Character.isLetterOrDigit(ch)){
                specialCharacter = true;
            }
        }
        passwordStatus = specialCharacter && number && length && upperCase;
        return passwordStatus;
    }
    
    public boolean registerAndLoginUser(){
        // Perform registration
        if(!checkUserName()){
            JOptionPane.showMessageDialog(null, "Registration\nUsername is not correctly formatted. Please ensure that your username contains an underscore and is no more than five characters in length.");
            return false; // Registration failed
        }
        
        if(!checkPasswordComplexity()){
            JOptionPane.showMessageDialog(null, "Registration\nPassword is not correctly formatted. Please ensure the password contains at least 8 characters, a capital letter, a number, and a special character.");
            return false; // Registration failed
        }
        
        JOptionPane.showMessageDialog(null, "Registration\nRegistration successful.");
        
        // Perform login
        String username2 = JOptionPane.showInputDialog("Login Details\nEnter your username:");
        String password2 = JOptionPane.showInputDialog("Login Details\nEnter your password:");
        
        if(Registration.username.equals(username2) && Registration.password.equals(password2)){
            JOptionPane.showMessageDialog(null, "Login Details\nLogin Successful.");
            return true; // Login successful
        } else {
            JOptionPane.showMessageDialog(null, "Login Details\nUsername or password is incorrect. Please try again.");
            return false; // Login failed
        }
    }

    // Method to perform login based on user input
    public boolean loginUser(String username, String password) {
        if (Registration.username.equals(username) && Registration.password.equals(password)) {
            return true; // Login successful
        } else {
            return false; // Login failed
        }
    }
}
