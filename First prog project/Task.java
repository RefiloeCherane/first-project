package ST10269417.Refiloe.Cherane.POE;
/**
 *
 * @author ST10269417 Refiloe Cherane
 */
import javax.swing.JOptionPane;

public class Task {
    UserInfo taskinput = new UserInfo();

    public boolean checkTaskDescription() {
        return taskinput.getDescription().length() <= 50;
    }

    public static String createTaskID() {
        String count = "";
        char character;
        for (int x = 0; x < UserInfo.getDeveloperNames().length(); x++) {
            character = UserInfo.getDeveloperNames().charAt(x);
            if (character == ' ') {
                count = UserInfo.getDeveloperNames().substring(x - 3, x);
            }
        }
        return (UserInfo.getTaskName().substring(0, 2) + ":" + UserInfo.getTaskNumber() + ":" + count).toUpperCase();
    }

    public static String printTaskDetails() {
        return UserInfo.getStatus() + "\n" + UserInfo.getDeveloperNames() + "\n" + UserInfo.getTaskNumber() + "\n" +
                UserInfo.getTaskName() + "\n" + UserInfo.getDescription() + "\n" + createTaskID() + "\n" + UserInfo.getDuration();
    }
}
