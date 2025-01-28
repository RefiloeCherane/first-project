package ST10269417.Refiloe.Cherane.POE;
/**
 *
 * @author ST10269417 Refiloe Cherane
 */
import javax.swing.JOptionPane;

public class Registration {
    static String name;
    static String username;
    static String surname;
    static String password;

    public static void userDetails() {
        name = JOptionPane.showInputDialog("Please enter your name");
        surname = JOptionPane.showInputDialog("Please enter your surname");
        username = JOptionPane.showInputDialog("Please create your username");
        password = JOptionPane.showInputDialog("Please create password");
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome To EasyKanban");

        userDetails();

        Login logObject = new Login();

        // Register and login process
        if (logObject.registerAndLoginUser()) {
            JOptionPane.showMessageDialog(null, "Thank you\n" +
                    name + " " + surname + "\n" +
                    "Login Successful.");

            UserInfo info = new UserInfo();
            info.WelcomeNote(logObject); // Pass the Login object to WelcomeNote
        } else {
            // Handle failed registration or login
            JOptionPane.showMessageDialog(null, "Registration or Login failed. Please try again.");
        }
    }
}
